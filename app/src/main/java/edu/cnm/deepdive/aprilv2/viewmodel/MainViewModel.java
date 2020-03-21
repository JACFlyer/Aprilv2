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

//  private void insertAssessment(ClientProfile clientProfile) {
//    AssessmentDao assessmentDao = database.getAssessmentDao();
//    Assessment assessment = new Assessment();
//    assessment.setClientId(ClientProfile.getClientId);
//    assessmentDao.insert(assessment)
//        .subscribeOn(Schedulers.io())
//        .subscribe(/*TODO Handle error result */);
//  }

//  private void insertFetalConditionDao(Assessment assessment) {
//    FetalHeartRateDao fetalConditionDao = database.getFetalConditionDao();
//    FetalHeartRate fetalCondition = new FetalHeartRate();
//    fetalCondition.setAssessmentId(Assessment.getAssessmentId);
//    fetalConditionDao.insert(fetalCondition)
//        .subscribeOn(Schedulers.io())
//        .subscribe(/*TODO Handle error result */);
//  }

//  private void insertLaborDao(Assessment assessment) {
//    ContractionDao laborDao = database.getLaborDao();
//    Contraction labor = new Contraction();
//    labor.setAssessmentId(Assessment.getAssessmentId);
//    laborDao.insert(labor)
//        .subscribeOn(Schedulers.io())
//        .subscribe(/*TODO Handle error result */);
//  }

  public void setAprilStart() {

  }

  public LiveData<Object> getAprilStart() {
    return null;
  }
}