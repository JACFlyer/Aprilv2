package edu.cnm.deepdive.aprilv2.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.schedulers.Schedulers;
import edu.cnm.deepdive.aprilv2.model.dao.AssessmentDao;
import edu.cnm.deepdive.aprilv2.model.dao.FetalConditionDao;
import edu.cnm.deepdive.aprilv2.model.dao.LaborDao;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.FetalCondition;
import edu.cnm.deepdive.aprilv2.model.entity.Labor;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;


public class MainViewModel extends AndroidViewModel implements LifecycleObserver {
  private MutableLiveData<Throwable> throwable;
  private AprilDatabase database;


  public MainViewModel(@NonNull Application application) {
    super(application);
    database = AprilDatabase.getInstance();
    throwable = new MutableLiveData<>();
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  private void insertAssessment(ClientProfile clientProfile) {
    AssessmentDao assessmentDao = database.getAssessmentDao();
    Assessment assessment = new Assessment();
    assessment.setClientId(ClientProfile.getClientId);
    assessmentDao.insert(assessment)
        .subscribeOn(Schedulers.io())
        .subscribe(/*TODO Handle error result */);
  }


  private void insertFetalConditionDao(Assessment assessment) {
    FetalConditionDao fetalConditionDao = database.getFetalConditionDao();
    FetalCondition fetalCondition = new FetalCondition();
    fetalCondition.setAssessmentId(Assessment.getAssessmentId);
    fetalConditionDao.insert(fetalCondition)
        .subscribeOn(Schedulers.io())
        .subscribe(/*TODO Handle error result */);
  }


  private void insertLaborDao(Assessment assessment) {
    LaborDao laborDao = database.getLaborDao();
    Labor labor = new Labor();
    labor.setAssessmentId(Assessment.getAssessmentId);
    laborDao.insert(labor)
        .subscribeOn(Schedulers.io())
        .subscribe(/*TODO Handle error result */);
  }

  public void setAprilStart() {
  }

  public LiveData<Object> getAprilStart() {
    return null;
  }
}