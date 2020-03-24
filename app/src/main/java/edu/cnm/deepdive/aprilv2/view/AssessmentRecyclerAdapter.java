package edu.cnm.deepdive.aprilv2.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.aprilv2.R;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.Contraction;
import edu.cnm.deepdive.aprilv2.model.entity.FetalHeartRate;
import edu.cnm.deepdive.aprilv2.model.entity.Journal;
import edu.cnm.deepdive.aprilv2.view.AssessmentRecyclerAdapter.AssessmentHolder;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssessmentRecyclerAdapter extends RecyclerView.Adapter<AssessmentHolder> {


  private final Context context;
  private final List<Assessment> assessments;
  private final Map<Class<? extends Assessment>, Integer> layouts;
  private final Map<Integer, Class<? extends AssessmentHolder>> holders;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;


  public AssessmentRecyclerAdapter(Context context,
      List<Assessment> assessments) {
    this.context = context;
    this.assessments = assessments;
    layouts = new HashMap<>();
    holders = new HashMap<>();
    dateFormat = android.text.format.DateFormat.getMediumDateFormat(context);
    timeFormat = android.text.format.DateFormat.getTimeFormat(context);
    layouts.put(Journal.class, R.layout.item_journal);
    holders.put(R.layout.item_journal, JournalHolder.class);
    layouts.put(Contraction.class, R.layout.item_contraction);
    holders.put(R.layout.item_contraction, ContractionHolder.class);
    layouts.put(FetalHeartRate.class, R.layout.item_fhr);
    holders.put(R.layout.item_fhr, FetalHeartRateHolder.class);



  }


  @Override
  public int getItemViewType(int position) {
    return layouts.get(assessments.get(position).getClass());
  }

  @NonNull
  @Override
  public AssessmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int layoutResId) {
    try {
      Class<? extends AssessmentHolder> holderClass = holders.get(layoutResId);
      Constructor<? extends AssessmentHolder> constructor =
          holderClass.getDeclaredConstructor(AssessmentRecyclerAdapter.class, View.class);
      View root = LayoutInflater.from(context).inflate(layoutResId, parent, false);
      return constructor.newInstance(this, root);
    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void onBindViewHolder(@NonNull AssessmentHolder holder, int position) {
    holder.bind(assessments.get(position));
  }

  @Override
  public int getItemCount() {
    return assessments.size();
  }

  abstract static class AssessmentHolder extends ViewHolder {

    public AssessmentHolder(@NonNull View itemView) {
      super(itemView);
    }

    public abstract void bind(Assessment assessment);

  }

  private class JournalHolder extends AssessmentHolder {

    private final TextView timestamp;
    private final TextView note;


    public JournalHolder(@NonNull View itemView) {
      super(itemView);
      timestamp = itemView.findViewById(R.id.timestamp);
      note = itemView.findViewById(R.id.note);
    }

    @Override
    public void bind(Assessment assessment) {
      Journal journal = (Journal) assessment;
      timestamp.setText(dateFormat.format(journal.getTimestamp()) + " " + timeFormat.format(journal.getTimestamp()));
      note.setText(journal.getNote());
    }
  }

  private class ContractionHolder extends AssessmentHolder {

    private final TextView timestamp;

    //  TODO Define UI fields.

    public ContractionHolder(@NonNull View itemView) {

      //  TODO Get references to UI fields.
      super(itemView);
      timestamp = itemView.findViewById(R.id.timestamp);

    }

    @Override
    public void bind(Assessment assessment) {
      Contraction contraction = (Contraction) assessment;
      timestamp.setText(dateFormat.format(contraction.getTimestamp()) + " " + timeFormat.format(contraction.getTimestamp()));

      //  TODO Populate UI fields with data from contraction.
    }
  }

  private class FetalHeartRateHolder extends AssessmentHolder {

    private final TextView timestamp;

    //  TODO Define UI fields.

    public FetalHeartRateHolder(@NonNull View itemView) {
      super(itemView);
      timestamp = itemView.findViewById(R.id.timestamp);

      //  TODO Get references to UI fields.
    }

    @Override
    public void bind(Assessment assessment) {
      FetalHeartRate fhr = (FetalHeartRate) assessment;
      timestamp.setText(dateFormat.format(fhr.getTimestamp()) + " " + timeFormat.format(fhr.getTimestamp()));

      //  TODO Populate UI fields with data from fhr.
    }
  }
}
