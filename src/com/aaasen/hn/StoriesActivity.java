package com.aaasen.hn;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class StoriesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stories);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		Document doc = Jsoup.parse(message);
		
		Elements links = doc.select("tr > td.title > a");
		ArrayList<Link> stories = new ArrayList<Link>();
		
		for (Element link : links) {
			stories.add(new Link(link.attr("href"), "", 123));
		}


		final ListView listview = (ListView) findViewById(R.id.listview);

		final HNArrayAdapter adapter = new HNArrayAdapter(this, stories.toArray(new Link[stories.size()]));

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
