package edu.cnm.deepdive.aprilv2;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * This is the application class.
 */
public class AprilApplication extends Application {


  /**
   * This onCreate method establishes the connection between Stetho and the AprilDatabase.
   */
  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    AprilDatabase.setContext(this);
  }
}
