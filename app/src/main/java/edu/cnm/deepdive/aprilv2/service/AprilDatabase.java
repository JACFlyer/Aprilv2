package edu.cnm.deepdive.aprilv2.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.aprilv2.MainActivity;
import edu.cnm.deepdive.aprilv2.model.dao.AssessmentDao;
import edu.cnm.deepdive.aprilv2.model.dao.ClientProfileDao;
import edu.cnm.deepdive.aprilv2.model.dao.FetalConditionDao;
import edu.cnm.deepdive.aprilv2.model.dao.LaborDao;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment;
import edu.cnm.deepdive.aprilv2.model.entity.Assessment.AssessmentType;
import edu.cnm.deepdive.aprilv2.model.entity.ClientProfile;
import edu.cnm.deepdive.aprilv2.model.entity.FetalCondition;
import edu.cnm.deepdive.aprilv2.model.entity.Labor;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase.Converters;
import java.util.Date;

/*  The @Database annotation, with an entities argument that specifies all of the entity classes in the data model. */
@Database(
      entities = {ClientProfile.class, Assessment.class, Labor.class, FetalCondition.class},
      version = 1,
      exportSchema = true
  )


  @TypeConverters({Converters.class, AssessmentType.class})

  public abstract class AprilDatabase extends RoomDatabase {

    private static final String DB_NAME = "client_db";

    /*  A private static field of the android.app.Application type settable to a public static setter. */
    private static MainActivity context;
    public static void setContext(MainActivity context) {
      AprilDatabase.context = context;
    }

    /* An implementation of the singleton pattern, with a getInstance() method that returns an instance of the class. */
    public static AprilDatabase getInstance() {
      return InstanceHolder.INSTANCE;
    }



    /* Abstract methods returning instances of DAO interfaces. */
    public abstract ClientProfileDao getClientProfileDao();
    public abstract AssessmentDao getAssessmentDao();
    public abstract LaborDao getLaborDao();
    public abstract FetalConditionDao getFetalConditionDao();

  public abstract Object signOut();


  public static class InstanceHolder {
      private static final AprilDatabase INSTANCE = Room.databaseBuilder(
          context, AprilDatabase.class, DB_NAME)
          .build();
    }

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
