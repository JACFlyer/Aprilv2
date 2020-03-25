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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the RecyclerView adapter for the AssessmentHolder.
 */
public class AssessmentRecyclerAdapter extends RecyclerView.Adapter<AssessmentHolder> {

  /**
   * Class fields The fields are constants as they manage the transference of view objects from the
   * three entities.
   */
  private final Context context;
  private final List<Assessment> assessments;
  private final Map<Class<? extends Assessment>, Integer> layouts;
  private final Map<Integer, Class<? extends AssessmentHolder>> holders;
  private final DateFormat dateFormat;
  private final DateFormat timeFormat;

  /**
   * Class constructor Herein, layouts from the input pages of the three entities are held in entity
   * specific holders and they will later be managed as [assessments] through the
   * AssessmentRepository.
   *
   * @param context
   * @param assessments
   */
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

  /**
   * These are nested classes which extend the AssessmentHolder class.  Each holds objects from the
   * an entity class.
   */

  /**
   * JournalHolder class
   */
  private class JournalHolder extends AssessmentHolder {

    /**
     * Class fields
     */
    private final TextView timestamp;
    private final TextView note;

    /**
     * Class constructor declares the the entity objects to be viewed.
     *
     * @param itemView
     */
    public JournalHolder(@NonNull View itemView) {
      super(itemView);
      timestamp = itemView.findViewById(R.id.timestamp);
      note = itemView.findViewById(R.id.note);
    }

    /**
     * This method binds (or declares) the (Journal assessment) object to be an object of the
     * Assessment class.
     *
     * @param assessment
     */
    @Override
    public void bind(Assessment assessment) {
      Journal journal = (Journal) assessment;
      timestamp.setText(dateFormat.format(journal.getTimestamp()) + " " + timeFormat
          .format(journal.getTimestamp()));
      note.setText(journal.getNote());
      /**clickView.setOnClickListener((v) ->
       listener.onJournalClick(getAdapterPosition(), note));
       **/

    }
  }

  /**
   * ContractionHolder class
   */
  private class ContractionHolder extends AssessmentHolder {

    /**
     * Class fields
     */
    private final TextView timestamp;
    private final TextView contractionStart;
    private final TextView contractionIntensity;
    private final TextView contractionEnd;

    /**
     * Class constructor declares the entity objects to be viewed.
     *
     * @param itemView
     */
    public ContractionHolder(@NonNull View itemView) {
      super(itemView);
      timestamp = itemView.findViewById(R.id.timestamp);
      contractionStart = itemView.findViewById(R.id.contraction_start_time);
      contractionIntensity = itemView.findViewById(R.id.contraction_pain_value);
      contractionEnd = itemView.findViewById(R.id.contraction_end_time);
    }

    /**
     * This method binds (or declares) the (Contraction assessment) object to be an object of the
     * Assessment class.
     *
     * @param assessment
     */
    @Override
    public void bind(Assessment assessment) {
      Contraction contraction = (Contraction) assessment;
      timestamp.setText(dateFormat.format(contraction.getTimestamp()) + " " + timeFormat
          .format(contraction.getTimestamp()));
      contractionStart.setText(dateFormat.format(contraction.getTimestamp()) + " " + timeFormat
          .format(contraction.getTimestamp()));
      contractionIntensity.setText(contraction.getIntensity());
      contractionEnd.setText(dateFormat.format(contraction.getTimestamp()) + " " + timeFormat
          .format(contraction.getTimestamp()));

      /**clickView.setOnClickListener((v) ->
       listener.onContractionClick(getAdapterPosition(), contractionStart, contractionEnd, contractionIntensity));
       **/

    }
  }

  /**
   * FetalHeartRateHolder class
   */
  private class FetalHeartRateHolder extends AssessmentHolder {

    /**
     * Class fields
     */
    private final TextView timestamp;
    private final TextView fhrValue;

    /**
     * The class constructor declares the entity objects to be viewed.
     *
     * @param itemView
     */
    public FetalHeartRateHolder(@NonNull View itemView) {
      super(itemView);
      timestamp = itemView.findViewById(R.id.timestamp);
      this.fhrValue = itemView.findViewById(R.id.fhr_value);
    }

    /**
     * This method binds (or declares) the (FetalHeartRate assessment) object to be an object of the
     * Assessment class.
     *
     * @param assessment
     */
    @Override
    public void bind(Assessment assessment) {
      FetalHeartRate fhr = (FetalHeartRate) assessment;
      timestamp.setText(
          dateFormat.format(fhr.getTimestamp()) + " " + timeFormat.format(fhr.getTimestamp()));
      fhrValue.setText(fhr.getFhr());

      /**clickView.setOnClickListener((v) ->
       listener.onFhrClick(getAdapterPosition(), fhrValue));
       **/
    }
  }
}