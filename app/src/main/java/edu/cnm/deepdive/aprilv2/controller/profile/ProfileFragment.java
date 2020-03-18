package edu.cnm.deepdive.aprilv2.controller.profile;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import edu.cnm.deepdive.aprilv2.R;

public class ProfileFragment extends PreferenceFragmentCompat {

  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.profile_settings, rootKey);
  }
}
