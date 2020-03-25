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

/**
 * This is the controller class for the Journal page.
 */
public class JournalFragment extends Fragment {

  /**
   * Class field
   */
  private RecyclerView journalList;


  /**
   * The onCreateView method inflates the layout of the Journal page.
   * Each fragment_journal (objects of notes with timestamps) is assigned to the journalList.
   * A FAB on the page allows for adding new notes.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return
   */
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View layout = inflater.inflate(R.layout.fragment_journal, container, false);
    journalList = layout.findViewById(R.id.fragment_journal);
    FloatingActionButton addJournal = layout.findViewById(R.id.add_journal);
    addJournal.setOnClickListener((v) -> addNote(null));
    return layout;
}

  /**
   * The addNote method remains to be constructed and bound to the FAB on the journal page.
   * @param note
   */
  private void addNote(String note) {
  }
}