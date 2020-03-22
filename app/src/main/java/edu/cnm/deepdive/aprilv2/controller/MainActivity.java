package edu.cnm.deepdive.aprilv2.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import edu.cnm.deepdive.aprilv2.viewmodel.MainViewModel;
import java.util.Calendar;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;
import edu.cnm.deepdive.aprilv2.R;


public class MainActivity extends AppCompatActivity {

  // private static final int EXTERNAL_STORAGE_REQUEST_CODE = 1000;

  private MainViewModel viewModel;
  private NavController navController;
  private ProgressBar loading;
  private Calendar calendar;
  private BottomNavigationView navigator;
  private NavOptions navOptions;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loading = findViewById(R.id.loading);
    setupNavigation();
    setupViewModel();
  }


  public void setProgressVisibility(int visibility) {
    loading.setVisibility(visibility);
  }


  public void showToast(String message) {
    setProgressVisibility(View.GONE);
    Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
    toast.setGravity(Gravity.BOTTOM, 0,
        getResources().getDimensionPixelOffset(R.dimen.toast_vertical_margin));
    toast.show();
  }

  private void setupViewModel() {
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getThrowable().observe(this, (throwable) -> {
      if (throwable != null) {
        showToast(getString(R.string.error_message, throwable.getMessage()));
      }
    });
    getLifecycle().addObserver(viewModel);
  }

  private void setupNavigation() {
    AppBarConfiguration appBarConfiguration =
        new AppBarConfiguration.Builder(R.id.fragment_april_start, R.id.fragment_action_page, R.id.fragment_profile)
            .build();
    navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    navigator = findViewById(R.id.navigator);
    NavigationUI.setupWithNavController(navigator, navController);



  }

}


