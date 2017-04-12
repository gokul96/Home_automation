package com.fidzeal.iotdevice.http_client;

import android.os.AsyncTask;
import android.util.Log;
import com.fidzeal.iotdevice.model.Model;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class HttpClientPost extends AsyncTask<String, Void, String> {
	private HttpClient mClient;
	private HttpPost mPost;
	private HttpResponse mResponse;
	private HttpParams mHttpParams;
	private String TAG = HttpClientPost.class.getName();
	private String response;

	@SuppressWarnings("deprecation")
	protected String doInBackground(String... params) {

		String url = params[0];
		String json = params[1];
		mHttpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(mHttpParams,
				Model.getSingleton().CONNECTION_TIMEOUT * 1000);
		mClient = new DefaultHttpClient(mHttpParams);
		try {
			mPost = new HttpPost(url);
			mPost.setHeader("Content-Type", "application/json");
			//mPost.setHeader("Accept", "application/json");

			if (json.contentEquals("")) {

			} else {
				StringEntity se = new StringEntity(json);
				mPost.setEntity(se);
			}
			mResponse = mClient.execute(mPost);
			int status = mResponse.getStatusLine().getStatusCode();
			if (status == 200 || status == 201 || status == 400 || status == 401) {
				response = convertStreamToString(mResponse.getEntity()
						.getContent());
			}
			else if (status == 408) {
				Log.e(TAG, "Connection Timed Out");
			} else {

				response = null;
			}

		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
		return response;
	}

	/**
	 * Convert data from url into a string
	 * 
	 * @param is
	 * @return
	 */
	public String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				// System.gc();
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				Log.e(TAG, e.getMessage());
			}
		}
		return sb.toString();
	}

}
