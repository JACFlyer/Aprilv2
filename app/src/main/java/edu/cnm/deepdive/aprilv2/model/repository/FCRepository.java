package edu.cnm.deepdive.aprilv2.model.repository;

import android.app.Application;
import edu.cnm.deepdive.aprilv2.model.dao.FetalConditionDao;
import edu.cnm.deepdive.aprilv2.model.entity.FetalCondition;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import io.reactivex.schedulers.Schedulers;

public class FCRepository {

  private static final int NETWORK_THREAD_COUNT = 10;

    private final AprilDatabase database;

    private static Application context;

    private FCRepository() {
      if (context == null) {
        throw new IllegalStateException();
      }
      database = AprilDatabase.getInstance();
    }

    public static void setContext(Application context) {
      edu.cnm.deepdive.aprilv2.model.repository.FCRepository.context = context;
    }

  /** Establishing Create CRUD-Operation **/
  private void insertFetalCondition(FetalCondition fetalCondition) {
    FetalConditionDao fetalConditionDao = database.getFetalConditionDao();
    FetalCondition fetalCondition1 = new FetalCondition();
    fetalCondition.setId(fetalCondition.getId());
    fetalConditionDao.insert(fetalCondition)
        .subscribeOn(Schedulers.io())
        .subscribe(/* TODO Handle repository specific error result */);
  }


  /**
   public LiveData<List<FetalCondition>> get() {
   return database.getFetalConditionDao();
   }**/






}
