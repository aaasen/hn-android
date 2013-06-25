package com.aaasen.hn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class StoriesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stories);

		final TextView textview = (TextView) findViewById(R.id.textview);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		textview.setText(message);
		
		
//		final ListView listview = (ListView) findViewById(R.id.listview);
//		
//		
//		
//		final HNArrayAdapter adapter = new HNArrayAdapter(this, links);
//
//		listview.setAdapter(adapter);
//
//		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, final View view,
//					int position, long id) {
//				Intent intent = new Intent(view.getContext(), CommentsActivity.class);
//		    	activity.startActivity(intent);
//			}
//		});
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
