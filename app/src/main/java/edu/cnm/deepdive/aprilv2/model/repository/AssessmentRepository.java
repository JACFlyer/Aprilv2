package edu.cnm.deepdive.aprilv2.model.repository;

import android.app.Application;
import edu.cnm.deepdive.aprilv2.model.dao.AssessmentDao;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import io.reactivex.schedulers.Schedulers;

/** Repository class declared **/
public class AssessmentRepository {

    private static final int NETWORK_THREAD_COUNT = 10;

    private final AprilDatabase database;

    private static Application context;

    /** Constructor for repository **/
    private AssessmentRepository() {
      if (context == null) {
        throw new IllegalStateException();
      }
      database = AprilDatabase.getInstance();
    }
    /** Establising context for the repository **/
    public static void setContext(Application context) {
      edu.cnm.deepdive.aprilv2.model.repository.AssessmentRepository.context = context;
    }
  /** Establishing Create CRUD-Operation **/
  private void insertAssessment(Assessment assessment) {
    AssessmentDao assessmentDao = database.getAssessmentDao();
    Assessment assessment1 = new Assessment();
    assessment.setAssessmentId(assessment.getId());
    assessmentDao.insert(assessment)
        .subscribeOn(Schedulers.io())
        .subscribe(/* TODO Handle repository specific error result */);
  }


  /**
  public LiveData<List<Assessment>> get() {
    return database.getAssessmentDao();
  }**/
  }
