package edu.cnm.deepdive.aprilv2.controller.assessment;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.Contraction;
import edu.cnm.deepdive.aprilv2.model.repository.AssessmentRepository;
import java.util.List;

public class AssessmentViewModel extends AndroidViewModel {

  private final Context context;
  private final MutableLiveData<List<Assessment>> assessments;
  private final MutableLiveData<Throwable> throwable;
  private final AssessmentRepository repository;



  public AssessmentViewModel(@NonNull Application application) {
    super(application);
    context = application;
    repository = new AssessmentRepository(application);
    assessments = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
  }

  public LiveData<List<Assessment>> getAssessments() {
    return assessments;
  }

  public void saveContraction(Contraction contraction) {
    repository.saveContraction(contraction)
        .subscribe(
            () -> {/* TODO Refresh list of assessments */},
            throwable::postValue
        );
  }
  //  TODO Create SAVE for Contraction and Fetal Heart Rate.
  //  TODO Implement a REFRESH method to refresh Live Data of Assessments
}
