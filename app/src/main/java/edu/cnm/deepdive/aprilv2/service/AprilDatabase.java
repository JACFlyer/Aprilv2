package edu.cnm.deepdive.aprilv2.service;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.aprilv2.model.dao.ContractionDao;
import edu.cnm.deepdive.aprilv2.model.dao.FetalHeartRateDao;
import edu.cnm.deepdive.aprilv2.model.dao.JournalDao;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.Contraction;
import edu.cnm.deepdive.aprilv2.model.entity.FetalHeartRate;
import edu.cnm.deepdive.aprilv2.model.entity.Journal;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase.Converters;
import java.util.Date;


/**
 * The @Database annotation, with an entities argument that specifies all of the entity classes in
 * the data model.
 **/
@Database(
    entities = {Journal.class, Contraction.class, FetalHeartRate.class},
    version = 1,
    exportSchema = true
)

/**
 * The AprilDatabase is herein constructed as an extension of the RoomDatabase.
 */
@TypeConverters({Converters.class})
public abstract class AprilDatabase extends RoomDatabase {

  /**
   * Class fields
   */
  private static final String DB_NAME = "client_db";

  /**
   * Constructors
   */
  private static Context context;

  public static void setContext(Context context) {
    AprilDatabase.context = context;
  }

  public static AprilDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract JournalDao getJournalDao();

  public abstract ContractionDao getContractionDao();

  public abstract FetalHeartRateDao getFetalHeartRateDao();


  /**
   * This nested class builds the instance of the database.
   */
  public static class InstanceHolder {

    private static final AprilDatabase INSTANCE = Room.databaseBuilder(
        context, AprilDatabase.class, DB_NAME)
        .build();
  }

  /**
   * These nested classes allow for the conversion of date and time types.
   */
  public static class Converters {

    @TypeConverter
    public static Long fromDate(Date date) {
      return (date != null) ? date.getTime() : null;
    }

    @TypeConverter
    public static Date fromLong(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }

}
