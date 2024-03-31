package edu.cnm.deepdive.leavemealone.controller;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.viewmodel.LocationViewModel;

public class CoordinatesDialogFragment extends DialogFragment{

  private LocationViewModel lvm;

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    return new AlertDialog.Builder(requireContext())
        .setTitle("Test Dialog")
        .setMessage("This is some text that you really should read carefully")
        .setPositiveButton(R.string.set_secure_label, (dlg, which) -> {
          lvm.markLocation(true);
        })
        .setNegativeButton(R.string.set_unsecure_label, (dlg, which) -> {
          lvm.markLocation(false);
        })
        .setNeutralButton(android.R.string.cancel, (dlg, which) -> {
        })
        .create();
  }

  @Override
  public void onStart() {
    super.onStart();
    ViewModelProvider provider = new ViewModelProvider(requireActivity());
    lvm = provider.get(LocationViewModel.class);
    // TODO: 3/30/2024 Set up any observers for lvm
  }
}
