package edu.cnm.deepdive.aprilv2.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.aprilv2.model.entity.Contraction;
import edu.cnm.deepdive.aprilv2.model.entity.FetalHeartRate;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This is the Dao interface for the FetalHeartRate class.
 */
@Dao
public interface FetalHeartRateDao {

  /**
   * These are insert, delete and query commands managing class information in the database.
   *
   * @param fetalHeartRate
   * @return
   */
  @Insert
  Single<Long> insert(FetalHeartRate fetalHeartRate);

  @Insert
  Single<List<Long>> insert(Collection<FetalHeartRate> fetalHeartRates);

  @Insert
  Single<List<Long>> insert(FetalHeartRate... fetalHeartRates);


  @Delete
  Single<Integer> delete(FetalHeartRate fetalHeartRate);

  @Delete
  Single<Integer> delete(Collection<FetalHeartRate> fetalHeartRates);

  @Delete
  Single<Integer> delete(FetalHeartRate... fetalHeartRates);


  @Query("SELECT * FROM FetalHeartRate ORDER BY timestamp DESC")
  Single<List<FetalHeartRate>> select();

  @Query("SELECT * FROM FetalHeartRate WHERE fetal_id = :id")
  Single<FetalHeartRate> select(long id);


}
