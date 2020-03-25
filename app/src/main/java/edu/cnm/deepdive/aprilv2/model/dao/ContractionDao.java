package edu.cnm.deepdive.aprilv2.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.Contraction;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This is the Dao interface for the Contraction class.
 */
@Dao
public interface ContractionDao {


  /**
   * These are insert, delete and query commands managing class information in the database.
   *
   * @param contraction
   * @return
   */
  @Insert
  Single<Long> insert(Contraction contraction);

  @Insert
  Single<List<Long>> insert(Collection<Contraction> contractions);

  @Insert
  Single<List<Long>> insert(Contraction... contractions);


  @Delete
  Single<Integer> delete(Contraction contraction);

  @Delete
  Single<Integer> delete(Collection<Contraction> contractions);

  @Delete
  Single<Integer> delete(Contraction... contractions);


  @Query("SELECT * FROM Contraction ORDER BY timestamp DESC")
  Single<List<Contraction>> select();

  @Query("SELECT * FROM Contraction WHERE contraction_id = :id")
  Single<Contraction> select(long id);


}
