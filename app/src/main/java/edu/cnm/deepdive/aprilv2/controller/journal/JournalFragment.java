package edu.cnm.deepdive.aprilv2.controller.journal;


import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.aprilv2.R;
import java.util.UUID;


public class JournalFragment extends Fragment {

  private RecyclerView journalList;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.fragment_journal, container, false);
    journalList = layout.findViewById(R.id.fragment_journal);
    FloatingActionButton addJournal = layout.findViewById(R.id.add_journal);
    addJournal.setOnClickListener((v) -> addNote(null));
    return layout;
}

  private void addNote(String note) {
  }
}