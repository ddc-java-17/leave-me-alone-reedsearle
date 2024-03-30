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
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmArmBinding;
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmWarningBinding;

/**
 * A simple {@link Fragment} subclass. Use the {@link AlarmWarningFragment#newInstance} factory
 * method to create an instance of this fragment.
 */
@AndroidEntryPoint
public class AlarmWarningFragment extends Fragment {

  private FragmentAlarmWarningBinding binding;

  public AlarmWarningFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentAlarmWarningBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    NavController navController = Navigation.findNavController(view);
    binding.codeTimeOut.setOnClickListener(
        (v) -> navController.navigate(AlarmWarningFragmentDirections.navigateSounding()));
    binding.disarmAlarm.setOnClickListener(
        (v) -> navController.navigate(ControlsFragmentDirections.navigateControls()));
  }
  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

}