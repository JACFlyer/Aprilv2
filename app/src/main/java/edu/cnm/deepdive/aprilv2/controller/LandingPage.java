package edu.cnm.deepdive.aprilv2.controller;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.aprilv2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandingPage extends Fragment {


  public LandingPage() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_landing_page, container, false);
  }

}
