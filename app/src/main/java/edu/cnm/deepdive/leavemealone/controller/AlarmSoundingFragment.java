package edu.cnm.deepdive.leavemealone.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmSoundingBinding;

/**
 * A simple {@link Fragment} subclass. Use the {@link AlarmSoundingFragment#newInstance} factory
 * method to create an instance of this fragment.
 */
public class AlarmSoundingFragment extends Fragment {

  private FragmentAlarmSoundingBinding binding;
  public AlarmSoundingFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentAlarmSoundingBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding.disarmAlarm.setOnClickListener(
        (button)->Navigation
            .findNavController(button)
            .navigate(ControlsFragmentDirections
                .navigateControls()) );
  }
}