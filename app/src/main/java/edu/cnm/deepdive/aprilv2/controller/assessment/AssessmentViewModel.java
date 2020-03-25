package edu.cnm.deepdive.aprilv2.controller.assessment;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.Contraction;
import edu.cnm.deepdive.aprilv2.model.entity.FetalHeartRate;
import edu.cnm.deepdive.aprilv2.model.entity.Journal;
import edu.cnm.deepdive.aprilv2.model.repository.AssessmentRepository;
import java.util.List;

/**
 * This is the controller class for the Assessment ViewModel. Here, all LiveData parented by the
 * three entity classes is managed under a single context and passed to a single repository.
 */
public class AssessmentViewModel extends AndroidViewModel {

  /**
   * Class fields.  These fields are "constants" and therefore final. [assessments] is the
   * instantiation of the common Assessment class wherein the objects of the three entity classes
   * are passed for view management.
   */
  private final Context context;
  private final MutableLiveData<List<Assessment>> assessments;
  private final MutableLiveData<Throwable> throwable;
  private final AssessmentRepository repository;


  /**
   * This constructor assigns values to the final fields.
   *
   * @param application
   */
  public AssessmentViewModel(@NonNull Application application) {
    super(application);
    context = application;
    repository = new AssessmentRepository(application);
    assessments = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
  }

  /**
   * This method returns the LiveData constituting the assessments field.
   *
   * @return
   */
  public LiveData<List<Assessment>> getAssessments() {
    return assessments;
  }

  /**
   * This method saves the information entered on the contraction page. This page has yet to be
   * constructed. The embedded refresh command has yet to be constructed.
   *
   * @param contraction
   */
  public void saveContraction(Contraction contraction) {
    repository.saveContraction(contraction)
        .subscribe(
            () -> {/* TODO Refresh list of assessments */},
            throwable::postValue
        );
  }

  /**
   * This method saves the information entered on the fetal heart rate page. This page has yet to be
   * constructed.  The embedded refresh command has yet to be constructed.
   *
   * @param fetalHeartRate
   */
  public void saveFetalHeartRate(FetalHeartRate fetalHeartRate) {
    repository.saveFetalHeartRate(fetalHeartRate)
        .subscribe(
            () -> {/* TODO Refresh list of assessments */},
            throwable::postValue
        );
  }

  /**
   * This method saves the information entered on the journal page.  This page has yet to be constructed.
   * The embedded refresh command has yet to be constructed.
   * @param journal
   */
  public void saveJournal(Journal journal) {
    repository.saveJournal(journal)
        .subscribe(
            () -> {/* TODO Refresh list of assessments */},
            throwable::postValue
        );
  }
}