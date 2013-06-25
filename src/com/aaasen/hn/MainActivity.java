package com.aaasen.hn;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.first.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FetchTask task = new FetchTask(findViewById(android.R.id.content));
        String[] params = new String[1];
        params[0] = "https://news.ycombinator.com/";
        task.execute(params);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class FetchTask extends AsyncTask<String, Void, String> {
		private View view;
		
		public FetchTask(View view) {
			this.view = view;
		}
		
		protected String doInBackground(String... urls) {
			String result = null;
			
			try {
				URL url = new URL(urls[0]);
				final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				InputStream input = connection.getInputStream();
				BufferedInputStream bufferedInput = new BufferedInputStream(input);

				ByteArrayBuffer buffer = new ByteArrayBuffer(50);
				int current = 0;
				while ((current = bufferedInput.read()) != -1) {
					buffer.append((byte) current);
				}

				result = new String(buffer.toByteArray());    
			} catch (IOException e) {

			}
			
			return result;
		}

		protected void onPostExecute(String result) {
			Intent intent = new Intent(view.getContext(), StoriesActivity.class);
			intent.putExtra(EXTRA_MESSAGE, result);
	    	startActivity(intent);
		}
	}

}

