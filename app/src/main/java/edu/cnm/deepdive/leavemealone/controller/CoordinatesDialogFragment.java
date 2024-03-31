package edu.cnm.deepdive.leavemealone.controller;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.viewmodel.LocationViewModel;

@AndroidEntryPoint
public class CoordinatesDialogFragment extends DialogFragment{

  private LocationViewModel viewModel;

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    return new AlertDialog.Builder(requireContext())
        .setTitle("Test Dialog")
        .setMessage("This is some text that you really should read carefully")
        .setPositiveButton(R.string.set_secure_label, (dlg, which) -> {
          viewModel.markLocation(true);
        })
        .setNegativeButton(R.string.set_unsecure_label, (dlg, which) -> {
          viewModel.markLocation(false);
        })
        .setNeutralButton(android.R.string.cancel, (dlg, which) -> {
        })
        .create();
  }

  @Override
  public void onStart() {
    super.onStart();
    ViewModelProvider provider = new ViewModelProvider(requireActivity());
    viewModel = provider.get(LocationViewModel.class);
//    LifecycleOwner owner =getViewLifecycleOwner();
    // TODO: 3/30/2024 Set up any observers for lvm
  }
}
