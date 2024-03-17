package edu.cnm.deepdive.leavemealone.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.databinding.FragmentControlsBinding;

/**
 * A simple {@link Fragment} subclass. Use the {@link ControlsFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
public class ControlsFragment extends Fragment {

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

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    NavController navController = Navigation
        .findNavController(view);
    binding.soundAlarm.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateSounding()));
    binding.armAlarm.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateArm()));
//    binding.setSecure.setOnClickListener();
//    binding.setUnsecure.setOnClickListener();

  }
}