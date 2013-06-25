package com.aaasen.hn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ListView listview = (ListView) findViewById(R.id.listview);
		
		Link[] links = new Link[] {
				new Link("SpaceX IPO", "http://google.com/", 1337),
				new Link("Wow this community is getting so oooooollllllllllllllllllllldddddddddddd", "http://google.com/", 12),
				new Link("PlayStation 4 runs FreeBSD", "http://google.com/", 104),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213),
				new Link("Placeholder Title", "http://google.com/", 213)
		};
		
		final HNArrayAdapter adapter = new HNArrayAdapter(this, links);

		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				Intent intent = new Intent(view.getContext(), CommentsActivity.class);
		    	startActivity(intent);
			}
		});
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
