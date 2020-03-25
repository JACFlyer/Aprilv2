package edu.cnm.deepdive.aprilv2.controller.aprilstart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.aprilv2.R;
import edu.cnm.deepdive.aprilv2.viewmodel.MainViewModel;


/**
 * This is the controller class for the Home page.
 */
public class AprilStartFragment extends Fragment {


  /**
   * These are fields of the class.
   */
  private RecyclerView aprilStart;
  private MainViewModel viewModel;


  /**
   * The onCreateView method inflates the layout for the fragment.
   *
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.fragment_april_start, container, false);
    aprilStart = layout.findViewById(R.id.fragment_april_start);
    return layout;
  }


  /**
   * The onViewCreated method assigns to the viewModel elements of the MainViewModel
   *
   * @param view
   * @param savedInstanceState
   */
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
  }
}
