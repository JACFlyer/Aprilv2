package edu.cnm.deepdive.aprilv2.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import edu.cnm.deepdive.aprilv2.model.entity.FetalCondition;
import edu.cnm.deepdive.aprilv2.model.entity.Labor;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;


@Dao
public interface LaborDao {

  /** Establishing Create CRUD-Operation **/
  @Insert
  Single<Long> insert(Labor labor);

  @Insert
  Single<List<Long>> insert(Collection<Labor> labors);

  @Insert
  Single<List<Long>> insert(Labor... labors);



  /** Establishing Read CRUD-Operation **/


  /** Establishing Update CRUD-Operation **/
 /** @Update
  Single<Long> update(Labor labor);

  @Update
  Single<List<Long>> update(Collection<Labor> labors);

  @Update
  Single<List<Long>> update(Labor... labors);
**/

  /** Establishing Delete CRUD-operation **/
  @Delete
  Single<Integer> delete(Labor labor);

  @Delete
  Single<Integer> delete(Collection<Labor> labors);

  @Delete
  Single<Integer> delete(Labor... labors);

}
