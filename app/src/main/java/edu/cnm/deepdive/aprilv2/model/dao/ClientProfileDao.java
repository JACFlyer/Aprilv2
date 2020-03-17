package edu.cnm.deepdive.aprilv2.model.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ClientProfileDao {


  /** Establishing Create CRUD-Operation **/
  @Insert
  Single<Long> insert(ClientProfile clientProfile);

  @Insert
  Single<List<Long>> insert(Collection<ClientProfile> clientProfile);

  @Insert
  Single<List<Long>> insert(ClientProfile... clientProfiles);


  /** Establishing Read CRUD-Operation **/

  /** Establishing Update CRUD-Operation **/
 /** @Update
  Single<Long> update(ClientProfile clientProfile);

  @Update
  Single<List<Long>> update(Collection<ClientProfile> clientProfiles);

  @Update
  Single<List<Long>> update(ClientProfile... clientProfiles);
**/


  /** Establishing Delete CRUD-Operation **/
  @Delete
  Single<Integer> delete(ClientProfile clientProfile);

  @Delete
  Single<Integer> delete(Collection<ClientProfile> clientProfile);

  @Delete
  Single<Integer> delete(ClientProfile... clientProfiles);

}



