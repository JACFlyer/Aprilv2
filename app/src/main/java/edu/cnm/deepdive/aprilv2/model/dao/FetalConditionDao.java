package edu.cnm.deepdive.aprilv2.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import edu.cnm.deepdive.aprilv2.model.entity.FetalCondition;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;


@Dao
public interface FetalConditionDao {

  /** Establishing Create CRUD-Operation **/
  @Insert
  Single<Long> insert(FetalCondition fetalCondition);

  @Insert
  Single<List<Long>> insert(Collection<FetalCondition> fetalConditions);

  @Insert
  Single<List<Long>> insert(FetalCondition... fetalConditions);


  /** Establishing Read CRUD-Operation **/
  @Query("SELECT * FROM FetalCondition ORDER BY fetal_id")
  List<FetalCondition> select();


  @Query("SELECT * FROM FetalCondition WHERE fetal_id = :id")
  Single<ClientProfile> select(long id);



  /** Establishing Update CRUD-Operation **/
  @Update
  Single<Long> update(FetalCondition fetalCondition);

  @Update
  Single<List<Long>> update(Collection<FetalCondition> fetalConditions);

  @Update
  Single<List<Long>> update(FetalCondition... fetalConditions);



  /** Establishing Delete CRUD-Operation **/
  @Delete
  Single<Integer> delete(FetalCondition fetalCondition);

  @Delete
  Single<Integer> delete(Collection<FetalCondition> fetalConditions);

  @Delete
  Single<Integer> delete(FetalCondition... fetalConditions);


}
