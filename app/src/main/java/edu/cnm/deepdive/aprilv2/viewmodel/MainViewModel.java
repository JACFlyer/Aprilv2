package edu.cnm.deepdive.aprilv2.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.schedulers.Schedulers;
import java.text.ParseException;
import java.util.Date;
import android.annotation.SuppressLint;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.aprilv2.BuildConfig;
import edu.cnm.deepdive.aprilv2.model.dao.ClientProfileDao;
import edu.cnm.deepdive.aprilv2.model.dao.AssessmentDao;
import edu.cnm.deepdive.aprilv2.model.dao.FetalConditionDao;
import edu.cnm.deepdive.aprilv2.model.dao.LaborDao;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.FetalCondition;
import edu.cnm.deepdive.aprilv2.model.entity.Labor;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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


  public void grantPermission(String permission) {

  }

  public void revokePermissions(String permission) {

  }

  public void setAprilStart() {

  }

  public LiveData<Object> getAprilStart() {
    return null;
  }
}