package edu.cnm.deepdive.aprilv2.model.repository;

import android.app.Application;
import edu.cnm.deepdive.aprilv2.model.dao.ClientProfileDao;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import io.reactivex.schedulers.Schedulers;

/** Establishing repository class **/
public class ClientProfileRepository {

    private static final int NETWORK_THREAD_COUNT = 10;

    private final AprilDatabase database;

    private static Application context;

    private ClientProfileRepository() {
      if (context == null) {
        throw new IllegalStateException();
      }
      database = AprilDatabase.getInstance();
    }

    /** Setting context for the repository **/
    public static void setContext(Application context) {
      edu.cnm.deepdive.aprilv2.model.repository.ClientProfileRepository.context = context;
    }


  /** Establishing Create CRUD-Operation **/
  private void insertClientProfile(ClientProfile clientProfile) {
    ClientProfileDao clientProfileDao = database.getClientProfileDao();
    ClientProfile clientProfile1 = new ClientProfile();
   clientProfile.setClientId(clientProfile.getClientId());
    clientProfileDao.insert(clientProfile)
        .subscribeOn(Schedulers.io())
        .subscribe(/* TODO Handle repository specific error result */);
  }


  /**
   public LiveData<List<ClientProfile>> get() {
   return database.getClientProfileDao();
   }**/


  }
