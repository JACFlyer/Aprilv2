package edu.cnm.deepdive.aprilv2.controller.actionpage;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.aprilv2.R;
import edu.cnm.deepdive.aprilv2.view.AssessmentRecyclerAdapter;
import edu.cnm.deepdive.aprilv2.viewmodel.MainViewModel;

/**
 * This is the controller class for the Action page.
 */
public class ActionPageFragment extends Fragment {

  /**
   * Class fields
   */
  private RecyclerView activitiesList;
  private MainViewModel viewModel;


  /**
   * The onCreateView method inflates the layout for the fragment
   *
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_action_page, container, false);
    activitiesList = root.findViewById(R.id.fragment_action_page);
    return root;
  }


  /**
   * The onViewCreated method assigns to the viewModel elements of the MainViewModel class. The
   * viewModel then receives objects from the Assessment class. onClickListeners remain to be
   * constructed for this method. This method is also responsible for refreshing the viewModel in
   * order to receive new objects from the Assessment class.
   *
   * @param view
   * @param savedInstanceState
   */
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getAssessments().observe(getViewLifecycleOwner(), (assessments) -> {
      //  TODO Define a listener to handle clicks or long presses.
      AssessmentRecyclerAdapter adapter = new AssessmentRecyclerAdapter(getContext(), assessments);
      activitiesList.setAdapter(adapter);
    });
    viewModel.refresh();
  }
}