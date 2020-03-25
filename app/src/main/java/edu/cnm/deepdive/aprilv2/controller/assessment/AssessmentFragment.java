package edu.cnm.deepdive.aprilv2.controller.assessment;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.aprilv2.R;

/**
 * This is the controller class for the AssessmentFragment.
 */
public class AssessmentFragment extends Fragment {


  /**
   * The AssessmentFragment is inflated by this onCreateView method.  The intention is that the
   * AssessmentFragment class will serve as a common reference for the three
   * entity classes (Journal, Contraction and FetalHeartRate).  thereby all of the objects of
   * the entities can be consolidated under one Assessment class and displayed uniformly in one ViewGroup
   * for the class.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_assessment, container, false);
  }

}
