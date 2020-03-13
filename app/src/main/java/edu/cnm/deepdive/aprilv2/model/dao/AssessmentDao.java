package edu.cnm.deepdive.aprilv2.model.dao;

import androidx.annotation.RequiresPermission.Read;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface AssessmentDao {

  /** Establishing Create CRUD-Operation **/
  @Insert
  Single<Long> insert(Assessment assessment);

  @Insert
  Single<List<Long>> insert(Collection<Assessment> assessments);

  @Insert
  Single<List<Long>> insert(Assessment... assessments);


  /** Establishing Read CRUD-Operation **/
  @Query("SELECT * FROM Assessment ORDER BY assessment_id") List<Assessment> select();

  @Query("SELECT * FROM Assessment WHERE assessment_id = :id") Single<Assessment> select(long id);


  /** Establishing Update CRUD-Operation **/
//  @Update
//  Single<Long> update(Assessment assessment);

//  @Update
//  Single<List<Long>> update(Collection<Assessment> assessments);

 // @Update
 // Single<List<Long>> update(Assessment... assessments);


  /** Establishing Delete CRUD-Operation **/
  @Delete
  Single<Integer> delete(Assessment assessment);

  @Delete
  Single<Integer> delete(Collection<Assessment> assessments);

  @Delete
  Single<Integer> delete(Assessment... assessments);

}