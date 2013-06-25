package com.aaasen.hn;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HNArrayAdapter extends ArrayAdapter<Story> {
	private final Context context;
	private final List<Story> items;

	public HNArrayAdapter(Context context, List<Story> items) {
		super(context, R.layout.link_preview, items);
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View linkView = inflater.inflate(R.layout.link_preview, parent, false);
	    
		TextView title = (TextView) linkView.findViewById(R.id.title);
	    title.setText(items.get(position).title);

		TextView score = (TextView) linkView.findViewById(R.id.points);
	    score.setText(Integer.toString(items.get(position).points));
	    
		return linkView;

	}
} 