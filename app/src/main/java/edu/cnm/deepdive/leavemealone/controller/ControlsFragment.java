package edu.cnm.deepdive.leavemealone.controller;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.leavemealone.databinding.FragmentControlsBinding;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;

/**
 * A simple {@link Fragment} subclass. Use the {@link ControlsFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
@AndroidEntryPoint
public class ControlsFragment extends Fragment {
public class ControlsFragment extends Fragment implements FusedLocationProviderClient {

  private FragmentControlsBinding binding;
  private FusedLocationProviderClient fusedLocationProviderClient;

  public ControlsFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentControlsBinding.inflate(inflater, container, false);
    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext());
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    NavController navController = Navigation
        .findNavController(view);
    binding.soundAlarm.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateSounding()));
    binding.armAlarm.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateArm()));
    binding.setSecure.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateSecure()));
    binding.setUnsecure.setOnClickListener(
        (v)-> fusedLocationProviderClient.getCurrentLocation().addOnSuccessListener(this,
            new OnSuccessListener<Location>() {
              @Override
              public void onSuccess(Location location) {
                if(location != null) {
                  GPSCoord.latitude = location.getLatitude();
                  GPSCoord.longitude = location.getLongitude();
                }
              }
            }));

  }

  }
  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

}