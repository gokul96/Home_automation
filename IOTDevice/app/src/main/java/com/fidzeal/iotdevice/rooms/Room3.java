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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fidzeal.iotdevice.R;
import com.fidzeal.iotdevice.http_client.HttpClientGet;
import com.fidzeal.iotdevice.http_client.HttpClientPost;
import com.fidzeal.iotdevice.model.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Room3 extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.room3);
        final SeekBar sk=(SeekBar) findViewById(R.id.seekBar1);

        sharedPreferences = getSharedPreferences(Model.getSingleton().IP_ADDRESS, Context.MODE_PRIVATE);
        pDialog = new ProgressDialog(Room3.this);
        pDialog.setMessage("Loading...");
        doRefresh();

        mTextView = (TextView) findViewById(R.id.mText);

        btnSeven = (Button) findViewById(R.id.btn7);
        btnEight = (Button) findViewById(R.id.btn8);



        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);

        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p=0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
               /* if(p<30)
                {
                    p=30;
                    sk.setProgress(p);
                }*/

                if(p==0 )
                {
                    JSONObject json = new JSONObject();
                    try {
                        json.put(Model.getSingleton().status, String.valueOf(0).toString());

                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }


                    httpClientPost = new HttpClientPost() {

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            pDialog = new ProgressDialog(Room3.this);
                            pDialog.setMessage("sending");
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
                                    if(status.contentEquals("Dim_success")){
                                        Toast.makeText(Room3.this,"Success!",Toast.LENGTH_LONG).show();


                                    }
                                    else{
                                        Toast.makeText(Room3.this,"Failure!",Toast.LENGTH_LONG).show();

                                    }
                                }
                                catch (Exception e){
                                    e.printStackTrace();

                                }
                            } else {
                                Toast.makeText(Room3.this, "internal error!", Toast.LENGTH_SHORT).show();

                            }

                        }
                    };
                    httpClientPost.execute(IP+Model.getSingleton().STATUS_URL_DIM,json.toString());

                }

                if(p>=1 && p<=25)
                {
                    JSONObject json = new JSONObject();
                    try {
                        json.put(Model.getSingleton().status, String.valueOf(1).toString());

                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }


                    httpClientPost = new HttpClientPost() {

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            pDialog = new ProgressDialog(Room3.this);
                            pDialog.setMessage("sending");
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
                                    if(status.contentEquals("Dim_success")){
                                        Toast.makeText(Room3.this,"Success!",Toast.LENGTH_LONG).show();
                                        hidePDialog();

                                    }
                                    else{
                                        Toast.makeText(Room3.this,"Failure!",Toast.LENGTH_LONG).show();
                                        hidePDialog();
                                    }
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                    hidePDialog();
                                }
                            } else {
                                Toast.makeText(Room3.this, "internal error!", Toast.LENGTH_SHORT).show();
                                hidePDialog();
                            }

                        }
                    };
                    httpClientPost.execute(IP+Model.getSingleton().STATUS_URL_DIM,json.toString());

                }
                if(p>=26 && p<=50)
                {
                    JSONObject json = new JSONObject();
                    try {
                        json.put(Model.getSingleton().status, String.valueOf(2).toString());

                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }


                    httpClientPost = new HttpClientPost() {

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            pDialog = new ProgressDialog(Room3.this);
                            pDialog.setMessage("sending");
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
                                    if(status.contentEquals("Dim_success")){
                                        Toast.makeText(Room3.this,"Success!",Toast.LENGTH_LONG).show();
                                        hidePDialog();
                                    }
                                    else{
                                        Toast.makeText(Room3.this,"Failure!",Toast.LENGTH_LONG).show();
                                        hidePDialog();
                                    }
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                    hidePDialog();
                                }
                            } else {
                                Toast.makeText(Room3.this, "internal error!", Toast.LENGTH_SHORT).show();
                                hidePDialog();
                            }

                        }
                    };
                    httpClientPost.execute(IP+Model.getSingleton().STATUS_URL_DIM,json.toString());

                }
                if(p>=51 && p<=100)
                {
                    JSONObject json = new JSONObject();
                    try {
                        json.put(Model.getSingleton().status, String.valueOf(3).toString());

                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }


                    httpClientPost = new HttpClientPost() {

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            pDialog = new ProgressDialog(Room3.this);
                            pDialog.setMessage("sending");
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
                                    if(status.contentEquals("Dim_success")){
                                        Toast.makeText(Room3.this,"Success!",Toast.LENGTH_LONG).show();
                                        hidePDialog();
                                    }
                                    else{
                                        Toast.makeText(Room3.this,"Failure!",Toast.LENGTH_LONG).show();
                                        hidePDialog();
                                    }
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                    hidePDialog();
                                }
                            } else {
                                Toast.makeText(Room3.this, "internal error!", Toast.LENGTH_SHORT).show();
                                hidePDialog();
                            }

                        }
                    };
                    httpClientPost.execute(IP+Model.getSingleton().STATUS_URL_DIM,json.toString());

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                p=progress;
                Log.d("Progress",""+p);




            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

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
            Toast.makeText(Room3.this,"Please set the IP address first",Toast.LENGTH_LONG).show();
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
            Toast.makeText(Room3.this,"Please set the IP address first",Toast.LENGTH_LONG).show();
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
                pDialog = new ProgressDialog(Room3.this);
                pDialog.setMessage("sending");
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
                            Toast.makeText(Room3.this,"Success!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Room3.this,"Failure!",Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(Room3.this, "internal error!", Toast.LENGTH_SHORT).show();
                }

            }
        };
        httpClientPost.execute(IP+Model.getSingleton().STATUS_URL,json.toString());
    }
}
