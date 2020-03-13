package edu.cnm.deepdive.aprilv2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.stetho.Stetho;
import io.reactivex.schedulers.Schedulers;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);
        AprilDatabase.setContext(this);
        AprilDatabase.getInstance().getClientProfileDao().delete()
            .subscribeOn(Schedulers.io())
            .subscribe();

    }
}