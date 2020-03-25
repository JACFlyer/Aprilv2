package edu.cnm.deepdive.aprilv2.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.aprilv2.model.entity.Journal;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This is the Dao interface for the Journal class.
 */
@Dao
public interface JournalDao {


  /**
   * These are insert, delete and query commands managing the class information in the database.
   *
   * @param journal
   * @return
   */
  @Insert
  Single<Long> insert(Journal journal);

  @Insert
  Single<List<Long>> insert(Collection<Journal> journals);

  @Insert
  Single<List<Long>> insert(Journal... journals);


  @Delete
  Single<Integer> delete(Journal journal);

  @Delete
  Single<Integer> delete(Collection<Journal> journals);

  @Delete
  Single<Integer> delete(Journal... journals);


  @Query("SELECT * FROM Journal ORDER BY timestamp DESC")
  Single<List<Journal>> select();

  @Query("SELECT * FROM Journal WHERE journal_id = :id")
  Single<Journal> select(long id);


}

