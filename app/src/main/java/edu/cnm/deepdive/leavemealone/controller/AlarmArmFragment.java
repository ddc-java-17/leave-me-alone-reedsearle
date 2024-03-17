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
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmArmBinding;

/**
 * A simple {@link Fragment} subclass. Use the {@link AlarmArmFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
public class AlarmArmFragment extends Fragment {

  private FragmentAlarmArmBinding binding;

  public AlarmArmFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentAlarmArmBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    NavController navController = Navigation.findNavController(view);
    binding.motion.setOnClickListener(
        (b)-> navController.navigate(AlarmArmFragmentDirections.navigateWarning()));
    binding.disarmAlarm.setOnClickListener(
        (v)-> navController.navigate(ControlsFragmentDirections.navigateControls()) );
  }
}