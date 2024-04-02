package edu.cnm.deepdive.leavemealone.controller;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;
import edu.cnm.deepdive.leavemealone.R;

/**
 * this instantiates the settings fragment
 */
public class SettingsFragment extends PreferenceFragmentCompat {

  @Override
  public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
    setPreferencesFromResource(R.xml.root_preferences, rootKey);
  }
}