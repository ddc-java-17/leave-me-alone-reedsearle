package edu.cnm.deepdive.leavemealone.util;

import android.text.TextWatcher;

/**
 * This interface creates a text watcher for the three screen that use a disarm password
 */
  public interface PasswordWatcher extends TextWatcher {

    @Override
    default void beforeTextChanged(CharSequence s, int start, int count, int after) {
      // Do nothing.
    }

    @Override
    default void onTextChanged(CharSequence s, int start, int before, int count) {
      // Do nothing.
    }
  }


