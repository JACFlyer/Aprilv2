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

public class AssessmentRepository {

  private static final int NETWORK_THREAD_COUNT = 10;

  private final AprilDatabase database;

  private final Context context;


  /**
   * Constructor for repository
   *
   * @param context
   **/
  public AssessmentRepository(Context context) {
    this.context = context;
    database = AprilDatabase.getInstance();
  }


/** Save Methods **/
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


/** getAll Method **/
  public Flowable<List<Assessment>> getAll() {
    return database.getContractionDao().select()
        .subscribeOn(Schedulers.io())
        .map((contractions) -> (List<Assessment>) new ArrayList<Assessment>(contractions))

        .concatWith(
            database.getFetalHeartRateDao().select().map((fetalHeartRates) -> new ArrayList<Assessment>(fetalHeartRates))
        )
        .concatWith(
            database.getJournalDao().select().map((journals) -> new ArrayList<Assessment>(journals))
        )
        .sorted();
  }


/** Remove Methods **/
public Completable remove(Journal journal) {
    return Completable.fromSingle(
        database.getJournalDao().delete(journal)
            .subscribeOn(Schedulers.io())
    );
  }

  public Completable remove(FetalHeartRate fetalHeartRate) {
    return Completable.fromSingle(
        database.getFetalHeartRateDao().delete(fetalHeartRate)
            .subscribeOn(Schedulers.io())
    );
  }

  public Completable remove(Contraction contraction) {
    return Completable.fromSingle(
        database.getContractionDao().delete(contraction)
            .subscribeOn(Schedulers.io())
    );
  }


}
