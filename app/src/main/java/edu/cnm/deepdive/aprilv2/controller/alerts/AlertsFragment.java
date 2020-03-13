package edu.cnm.deepdive.aprilv2.controller.alerts;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.aprilv2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertsFragment extends Fragment {


  public AlertsFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_alerts, container, false);
  }

}
