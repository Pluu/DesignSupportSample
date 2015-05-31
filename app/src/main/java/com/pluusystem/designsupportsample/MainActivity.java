package com.pluusystem.designsupportsample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.InjectView;
import com.pluusystem.designsupportsample.fragment.FloatingButtonFragment;
import com.pluusystem.designsupportsample.fragment.FloatingLabelFragment;
import com.pluusystem.designsupportsample.fragment.MainFragment;
import com.pluusystem.designsupportsample.fragment.TabsFragment;

public class MainActivity extends AppCompatActivity
	implements NavigationView.OnNavigationItemSelectedListener {

	@InjectView(R.id.main_tool_bar)
	Toolbar toolBar;
	@InjectView(R.id.main_drawer_view)
	NavigationView navigationView;
	@InjectView(R.id.drawer_layout)
	DrawerLayout drawerLayout;

	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);

		setSupportActionBar(toolBar);

		mDrawerToggle
			= new ActionBarDrawerToggle(this, drawerLayout, toolBar,
										R.string.app_name, R.string.app_name);
		mDrawerToggle.setDrawerIndicatorEnabled(true);
		drawerLayout.setDrawerListener(mDrawerToggle);

		navigationView.setNavigationItemSelectedListener(this);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();

		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction()
			   .replace(R.id.main_frame, MainFragment.newInstance())
			   .commit();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onNavigationItemSelected(MenuItem menuItem) {
		int id = menuItem.getItemId();

		Fragment fragment = null;
		switch (id) {
			case R.id.navi_group1_item0:
				fragment = MainFragment.newInstance();
				break;
			case R.id.navi_group1_item1:
				fragment = FloatingLabelFragment.newInstance();
				break;
			case R.id.navi_group1_item2:
				fragment = FloatingButtonFragment.newInstance();
				break;
			case R.id.navi_group1_item3:
				fragment = TabsFragment.newInstance();
				break;
			case R.id.navi_group1_item4:
				startActivity(new Intent(this, AppBarActivity.class));
				break;
		}

		if (fragment != null) {
			FragmentManager manager = getSupportFragmentManager();
			manager.beginTransaction()
				   .replace(R.id.main_frame, fragment)
				   .commit();

			drawerLayout.closeDrawers();
			menuItem.setChecked(true);
		}
		return true;
	}

}
