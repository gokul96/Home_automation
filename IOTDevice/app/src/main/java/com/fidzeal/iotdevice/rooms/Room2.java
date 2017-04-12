package com.fidzeal.iotdevice.rooms;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fidzeal.iotdevice.R;
import com.fidzeal.iotdevice.http_client.HttpClientGet;
import com.fidzeal.iotdevice.http_client.HttpClientPost;
import com.fidzeal.iotdevice.model.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Room2 extends AppCompatActivity implements View.OnClickListener {

    public final String TAG = "Room1";
    private Button btnOne, btnTwo, btnThree, btnFour,btnFive,btnSix,btnSeven,btnEight;
    private TextView mTextView;
    private HttpClientGet httpClientGet;
    private ProgressDialog pDialog;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    private String IP;
    private HttpClientPost httpClientPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);

        sharedPreferences = getSharedPreferences(Model.getSingleton().IP_ADDRESS, Context.MODE_PRIVATE);
        pDialog = new ProgressDialog(Room2.this);
        pDialog.setMessage("Loading...");
        doRefresh();

        mTextView = (TextView) findViewById(R.id.mText);
        btnOne = (Button) findViewById(R.id.btn1);
        btnTwo = (Button) findViewById(R.id.btn2);
        btnThree = (Button) findViewById(R.id.btn3);
        btnFour = (Button) findViewById(R.id.btn4);
        btnFive = (Button) findViewById(R.id.btn5);
        btnSix = (Button) findViewById(R.id.btn6);
        btnSeven = (Button) findViewById(R.id.btn7);
        btnEight = (Button) findViewById(R.id.btn8);


        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                getName(1);
                break;
            case R.id.btn2:
                getName(2);
                break;
            case R.id.btn3:
                getName(3);
                break;
            case R.id.btn4:
                getName(4);
                break;
            case R.id.btn5:
                getName(5);
                break;
            case R.id.btn6:
                getName(6);
                break;
            case R.id.btn7:
                getName(7);
                break;
            case R.id.btn8:
                getName(8);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                setupIpDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void doRefresh() {
        IP = sharedPreferences.getString(Model.getSingleton().ip,"");
        Log.i(TAG,"IP Address::::"+IP);
        if(IP.contentEquals("")){
            Toast.makeText(Room2.this,"Please set the IP address first",Toast.LENGTH_LONG).show();
            return;
        }

        httpClientGet = new HttpClientGet() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                if(pDialog != null)
                pDialog.show();

            }

            @Override
            protected void onPostExecute(String results) {
                super.onPostExecute(results);
                hidePDialog();
                if (results != null) {

                    mTextView.setText("Server Refreshed!");

                } else {
                    mTextView.setText("Internal Network Error!");
                }

            }
        };
        httpClientGet.execute(IP+Model.getSingleton().REFRESH_URL);

    }



    private void setupIpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Your IP Address");

        final EditText input = new EditText(this);
        IP = sharedPreferences.getString(Model.getSingleton().ip,"");
        if(IP.contentEquals("")){
            input.setText("http://00.00.00.00");
        }
        else{
            input.setText(IP);
        }


        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                sharedPreferences.edit().putString(Model.getSingleton().ip,m_Text).commit();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void getName(int switchNumber){

        IP = sharedPreferences.getString(Model.getSingleton().ip,"");
        Log.i(TAG,"IP Address::::"+IP);
        if(IP.contentEquals("")){
            Toast.makeText(Room2.this,"Please set the IP address first",Toast.LENGTH_LONG).show();
            return;
        }


        JSONObject json = new JSONObject();
        try {
            json.put(Model.getSingleton().status, String.valueOf(switchNumber).toString());

        } catch (JSONException e1) {
            e1.printStackTrace();
        }


        httpClientPost = new HttpClientPost() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                pDialog = new ProgressDialog(Room2.this);
                pDialog.setMessage("Loading...");
                pDialog.show();

            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                hidePDialog();
                if (result != null) {
                    try {

                        JSONObject jsonObject1 = new JSONObject(result);
                        String status = jsonObject1.getString("ACK");
                        if(status.contentEquals("success")){
                            Toast.makeText(Room2.this,"Success!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Room2.this,"Failure!",Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(Room2.this, "internal error!", Toast.LENGTH_SHORT).show();
                }

            }
        };
        httpClientPost.execute(IP+Model.getSingleton().STATUS_URL,json.toString());
    }
}
