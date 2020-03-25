package edu.cnm.deepdive.aprilv2.controller.profile;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import edu.cnm.deepdive.aprilv2.R;

/**
 * This is the controller class for the Profile page.
 * Preferences are engaged here.
 */
public class ProfileFragment extends PreferenceFragmentCompat {

  /**
   * The onCreatePreferences method inflates the preferences resource, profile_settings.
   * @param savedInstanceState
   * @param rootKey
   */
  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.profile_settings, rootKey);
  }
  /**
   * Additional methods for passing the preference values on to a scrollerview
   * displaying the input information, and inflating the scrollerview are needed.
   */
}
