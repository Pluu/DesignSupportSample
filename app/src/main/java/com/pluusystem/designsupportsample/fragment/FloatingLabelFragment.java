package com.pluusystem.designsupportsample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pluusystem.designsupportsample.R;

/**
 * Created by PLUUSYSTEM-NEW on 2015-05-31.
 */
public class FloatingLabelFragment extends Fragment {
	public static FloatingLabelFragment newInstance() {
		FloatingLabelFragment fragment = new FloatingLabelFragment();
		return fragment;
	}

	public FloatingLabelFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_floating_label, container, false);
		return rootView;
	}
}
