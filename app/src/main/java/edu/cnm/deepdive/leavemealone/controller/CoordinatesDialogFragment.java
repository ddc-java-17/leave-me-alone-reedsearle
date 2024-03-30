package edu.cnm.deepdive.leavemealone.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import edu.cnm.deepdive.leavemealone.R;

public class CoordinatesDialogFragment extends DialogFragment {

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    return new AlertDialog.Builder(requireContext())
        .setTitle("Test Dialog")
        .setMessage("This is some text that you really should read carefully")
        .setPositiveButton(R.string.set_secure_label,  (dlg, which)->{})
        .setNegativeButton(R.string.set_unsecure_label,  (dlg, which)->{})
        .setNeutralButton(android.R.string.cancel, (dlg, which)->{})
        .create();
  }

//      binding.displayLocations.setOnClickListener(
//        (v)-> fusedLocationProviderClient.getCurrentLocation().addOnSuccessListener(this,
//            new OnSuccessListener<Location>() {
//              @Override
//              public void onSuccess(Location location) {
//                if(location != null) {
//                  GPSCoord.latitude = location.getLatitude();
//                  GPSCoord.longitude = location.getLongitude();
//                }
//              }
//            }));


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return super.onCreateView(inflater, container, savedInstanceState);
  }
}
