package edu.cnm.deepdive.aprilv2;

import android.Manifest.permission;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import edu.cnm.deepdive.aprilv2.DateTimePickerFragment;
import edu.cnm.deepdive.aprilv2.DateTimePickerFragment.Mode;
import edu.cnm.deepdive.aprilv2.viewmodel.MainViewModel;
import java.util.LinkedList;
import java.util.List;
import com.facebook.stetho.Stetho;
import io.reactivex.schedulers.Schedulers;
import edu.cnm.deepdive.aprilv2.service.AprilDatabase;


public class MainActivity extends AppCompatActivity {

  private static final int EXTERNAL_STORAGE_REQUEST_CODE = 1000;

  private MainViewModel viewModel;
  private NavController navController;
  private ProgressBar loading;
  private BottomNavigationView navigator;
  private NavOptions navOptions;

    public MainActivity(NavOptions navOptions,
        AprilDatabase googleSignInRepository) {
        this.navOptions = navOptions;
    }

    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      Stetho.initializeWithDefaults(this);
      setContentView(R.layout.activity_main);
      AprilDatabase.setContext(this);
      AprilDatabase.getInstance().getClientProfileDao().delete()
          .subscribeOn(Schedulers.io())
          .subscribe();
      loading = findViewById(R.id.loading);
    setupNavigation();
    setupViewModel();
    checkPermissions(permission.READ_EXTERNAL_STORAGE, permission.WRITE_EXTERNAL_STORAGE);
  }

@Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.main_options, menu);
    return true;
  }


  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    //noinspection SwitchStatementWithTooFewBranches
    switch (item.getItemId()) {
      case R.id.sign_out:
        AprilDatabase.getInstance().signOut()
            .addOnCompleteListener((task) -> {
              Intent intent = new Intent(this, LoginActivity.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            });
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == EXTERNAL_STORAGE_REQUEST_CODE) {
     for (int i = 0; i < permissions.length; i++) {
       String permission = permissions[i];
       int result = grantResults[i];
       if (result == PackageManager.PERMISSION_GRANTED) {
          viewModel.grantPermission(permission);
       } else {
          viewModel.revokePermissions(permission);
       }
     }
    } else {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
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
    }

  private void setupNavigation() {
    navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    navigator = findViewById(R.id.navigator);
    navigator.setOnNavigationItemSelectedListener((item) -> {
      navigateTo(item.getItemId());
      return true;
    });
  }


  private void navigateTo(int itemId) {
    if (navController.getCurrentDestination().getId() != itemId) {
      navController.navigate(itemId, null, navOptions);
      if (navigator.getSelectedItemId() != itemId) {
        navigator.setSelectedItemId(itemId);
      }
    }
  }

  private void checkPermissions(String... permissions) {
    List<String> permissionsToRequest = new LinkedList<>();
    List<String> permissionsToExplain = new LinkedList<>();
    for (String permission : permissions) {
      if (ContextCompat.checkSelfPermission(this, permission)
          != PackageManager.PERMISSION_GRANTED) {
        permissionsToRequest.add(permission);
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
          permissionsToExplain.add(permission);
        }
      } else {
        viewModel.grantPermission(permission);
      }
    }
    if (!permissionsToExplain.isEmpty()) {
      // TODO Explain to user.
    }
    if (!permissionsToRequest.isEmpty()) {
      ActivityCompat.requestPermissions(this, permissionsToRequest.toArray(new String[0]),
          EXTERNAL_STORAGE_REQUEST_CODE);
    }
  }
}
