package edu.cnm.deepdive.aprilv2.model.repository;

import android.app.Application;
import edu.cnm.deepdive.aprilv2.model.dao.LaborDao;
import edu.cnm.deepdive.aprilv2.model.entity.Labor;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import io.reactivex.schedulers.Schedulers;

public class LaborRepository {

    private static final int NETWORK_THREAD_COUNT = 10;

    private final AprilDatabase database;

    private static Application context;

    private LaborRepository() {
      if (context == null) {
        throw new IllegalStateException();
      }
      database = AprilDatabase.getInstance();
    }

    public static void setContext(Application context) {
      edu.cnm.deepdive.aprilv2.model.repository.LaborRepository.context = context;
    }

  /** Establishing Create CRUD-Operation **/
  private void insertLabor(Labor labor) {
    LaborDao laborDao = database.getLaborDao();
    Labor labor1 = new Labor();
    labor.setLaborId(labor.getLaborId());
    laborDao.insert(labor)
        .subscribeOn(Schedulers.io())
        .subscribe(/* TODO Handle repository specific error result */);
  }


  /**
   public LiveData<List<Labor>> get() {
   return database.getLaborDao();
   }**/


}
