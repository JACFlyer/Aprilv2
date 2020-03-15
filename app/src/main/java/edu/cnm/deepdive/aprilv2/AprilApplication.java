package edu.cnm.deepdive.aprilv2;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import io.reactivex.schedulers.Schedulers;

public class AprilApplication extends Application {


  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    AprilDatabase.setContext(this);
    AprilDatabase.getInstance().getClientProfileDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();

  }
}
