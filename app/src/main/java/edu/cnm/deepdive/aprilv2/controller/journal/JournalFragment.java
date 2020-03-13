package edu.cnm.deepdive.aprilv2.controller.journal;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.aprilv2.MainActivity;
import edu.cnm.deepdive.aprilv2.R;
import edu.cnm.deepdive.aprilv2.viewmodel.MainViewModel;




/**
 * A simple {@link Fragment} subclass.
 */
public class JournalFragment extends Fragment {
  private RecyclerView journalList;

  public JournalFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.fragment_journal, container, false);
    journalList = layout.findViewById(R.id.journal_subject);
    return layout;
  }


/**
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    MainViewModel viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getAllApodSummaries().observe(getViewLifecycleOwner(), (apods) -> {
      JournalFragmentRecyclerAdapter adapter = new JournalFragmentRecyclerAdapter(getContext(), apods, (v, apod, pos) ->
          ((MainActivity) getActivity()).loadJournalFragment(journalList.getDate()));
      journalList.setAdapter(adapter);
    });
  }
**/
}
