package edu.cnm.deepdive.aprilv2.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.repository.AssessmentRepository;
import java.util.List;


public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private AssessmentRepository repository;

  private MutableLiveData<Throwable> throwable;
  private MutableLiveData<List<Assessment>> assessments;


  public MainViewModel(@NonNull Application application) {
    super(application);
    throwable = new MutableLiveData<>();
    repository = new AssessmentRepository(application);
    assessments = new MutableLiveData<>();
  }

  public void refresh() {
    repository.getAll()
        .subscribe(
            assessments::postValue,
            throwable::postValue
        );
  }

  public LiveData<List<Assessment>> getAssessments() {
    return assessments;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }


  public void setAprilStart() {

  }

  public LiveData<Object> getAprilStart() {
    return null;
  }
}