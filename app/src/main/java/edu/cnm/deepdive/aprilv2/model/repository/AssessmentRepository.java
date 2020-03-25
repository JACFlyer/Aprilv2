package edu.cnm.deepdive.aprilv2.model.repository;

import android.app.Application;
import android.content.Context;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.Contraction;
import edu.cnm.deepdive.aprilv2.model.entity.FetalHeartRate;
import edu.cnm.deepdive.aprilv2.model.entity.Journal;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the sole entity-related repository class for the application.
 */
public class AssessmentRepository {

  /**
   * Class fields
   */
  private static final int NETWORK_THREAD_COUNT = 10;

  private final AprilDatabase database;

  private final Context context;


  /**
   * Constructor
   *
   * @param context
   */
  public AssessmentRepository(Context context) {
    this.context = context;
    database = AprilDatabase.getInstance();
  }


  /**
   * Save methods
   *
   * @param journal
   * @return
   */
  public Completable saveJournal(Journal journal) {
    return Completable.fromSingle(
        database.getJournalDao().insert(journal)
            .subscribeOn(Schedulers.io())
    );
  }

  public Completable saveContraction(Contraction contraction) {
    return Completable.fromSingle(
        database.getContractionDao().insert(contraction)
            .subscribeOn(Schedulers.io())
    );
  }

  public Completable saveFetalHeartRate(FetalHeartRate fetalheartrate) {
    return Completable.fromSingle(
        database.getFetalHeartRateDao().insert(fetalheartrate)
            .subscribeOn(Schedulers.io())
    );
  }


  /**
   * Method to getAll
   *
   * @return
   */
  public Flowable<List<Assessment>> getAll() {
    return database.getContractionDao().select()
        .subscribeOn(Schedulers.io())
        .map((contractions) -> (List<Assessment>) new ArrayList<Assessment>(contractions))

        .concatWith(
            database.getFetalHeartRateDao().select()
                .map((fetalHeartRates) -> new ArrayList<Assessment>(fetalHeartRates))
        )
        .concatWith(
            database.getJournalDao().select().map((journals) -> new ArrayList<Assessment>(journals))
        )
        .sorted();
  }


  /**
   * Remove methods
   *
   * @param journal
   * @return
   */
  public Completable removeJournal(Journal journal) {
    return Completable.fromSingle(
        database.getJournalDao().delete(journal)
            .subscribeOn(Schedulers.io())
    );
  }

  public Completable removeFetalHeartRate(FetalHeartRate fetalHeartRate) {
    return Completable.fromSingle(
        database.getFetalHeartRateDao().delete(fetalHeartRate)
            .subscribeOn(Schedulers.io())
    );
  }

  public Completable removeContraction(Contraction contraction) {
    return Completable.fromSingle(
        database.getContractionDao().delete(contraction)
            .subscribeOn(Schedulers.io())
    );
  }


}
