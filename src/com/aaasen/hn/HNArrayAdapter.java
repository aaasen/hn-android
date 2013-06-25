package com.aaasen.hn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HNArrayAdapter extends ArrayAdapter<Link> {
	private final Context context;
	private final Link[] links;

	public HNArrayAdapter(Context context, Link[] links) {
		super(context, R.layout.link_preview, links);
		this.context = context;
		this.links = links;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View linkView = inflater.inflate(R.layout.link_preview, parent, false);
	    TextView title = (TextView) linkView.findViewById(R.id.title);
	    title.setText(links[position].title);

		return linkView;

	}
} 