package com.pluusystem.designsupportsample.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.pluusystem.designsupportsample.R;

/**
 * Created by PLUUSYSTEM-NEW on 2015-05-31.
 */
public class FloatingButtonFragment extends Fragment
	implements View.OnClickListener {

	@InjectView(R.id.coordinatorLayout)
	CoordinatorLayout coordinatorLayout;

	public static FloatingButtonFragment newInstance() {
		FloatingButtonFragment fragment = new FloatingButtonFragment();
		return fragment;
	}

	public FloatingButtonFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_floating_button, container, false);
		ButterKnife.inject(this, rootView);
		return rootView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

	@OnClick(R.id.actionButton)
	public void viwSnackBar() {
		Snackbar
			.make(coordinatorLayout, R.string.snackbar_text, Snackbar.LENGTH_LONG)
			.setAction(R.string.snackbar_action, this)
			.setActionTextColor(getResources().getColor(R.color.color_snackbar_action))
			.show();
	}

	@Override
	public void onClick(View v) { }
}
