package edu.cnm.deepdive.aprilv2.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.aprilv2.model.entity.Journal;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface JournalDao {


     /** Establishing Create CRUD-Operation **/
    @Insert
    Single<Long> insert(Journal note);

    @Insert
    Single<List<Long>> insert(Collection<Journal> note);

    @Insert
    Single<List<Long>> insert(Journal... note);



    /** Establishing Delete CRUD-Operation **/
    @Delete
    Single<Integer> delete(Journal note);

    @Delete
    Single<Integer> delete(Collection<Journal> notes);

    @Delete
    Single<Integer> delete(Journal... notes);



    @Query("SELECT * FROM Journal ORDER BY timestamp DESC")
    Single<List<Journal>> select();

    @Query("SELECT * FROM Journal WHERE journal_id = :id")
    Single<Journal> select(long id);


  }

