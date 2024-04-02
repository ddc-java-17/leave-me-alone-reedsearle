package edu.cnm.deepdive.leavemealone.controller;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.databinding.FragmentControlsBinding;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;

/**
 * A simple {@link Fragment} subclass. Use the {@link ControlsFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
@AndroidEntryPoint
public class ControlsFragment extends Fragment{

  private FragmentControlsBinding binding;

  public ControlsFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentControlsBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  /**
   * This provides the basic navigation required for the app.  From here, the alarm may be
   * activated directly, the system may be armed and locations may be set for future reference.
   * @param view
   * @param savedInstanceState
   */
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    NavController navController = Navigation
        .findNavController(view);
    binding.soundAlarm.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateSounding()));
    binding.armAlarm.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateArm()));
    binding.setLocation.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateSetLocation()));
    binding.displayLocations.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateDisplayLocations()));
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }
}

