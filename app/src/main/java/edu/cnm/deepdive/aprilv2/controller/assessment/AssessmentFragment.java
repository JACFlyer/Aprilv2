package edu.cnm.deepdive.aprilv2.controller.assessment;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.aprilv2.R;

public class AssessmentFragment extends Fragment {




  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_assessment, container, false);
  }

}
