package com.pluusystem.designsupportsample;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AppBarActivity extends AppCompatActivity {

	@InjectView(R.id.recyclerView)
	RecyclerView recyclerView;
	@InjectView(R.id.toolbar)
	Toolbar toolBar;
	@InjectView(R.id.collapsingToolbarLayout)
	CollapsingToolbarLayout collapsingToolbarLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_bar);
		ButterKnife.inject(this);

		setSupportActionBar(toolBar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		collapsingToolbarLayout.setTitle(getString(R.string.title_activity_app_bar));
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		List<String> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add("Item=" + i);
		}

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(new MyAdapter(list));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

		private final List<String> list;

		public MyAdapter(List<String> list) {
			this.list = list;
		}

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
			View view
				= LayoutInflater.from(viewGroup.getContext())
								.inflate(R.layout.layout_recycler_item, viewGroup, false);
			return new MyViewHolder(view);
		}

		@Override
		public void onBindViewHolder(MyViewHolder viewHolder, int position) {
			String text = list.get(position);
			viewHolder.title.setText(text);
		}

		@Override
		public int getItemCount() {
			return list.size();
		}
	}

	private class MyViewHolder extends RecyclerView.ViewHolder {
		public TextView title;

		public MyViewHolder(View itemView) {
			super(itemView);
			title = (TextView) itemView.findViewById(R.id.textView);

		}
	}
}
