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
import edu.cnm.deepdive.aprilv2.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActionPageFragment extends Fragment {

  private RecyclerView activitiesList;
  private MainViewModel viewModel;





  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root = inflater.inflate(R.layout.fragment_action_page, container, false);
    activitiesList = root.findViewById(R.id.activities_list);
    return root;
  }


  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
  }
}



