package edu.cnm.deepdive.leavemealone.controller;

import static java.lang.System.currentTimeMillis;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmWarningBinding;

/**
 * A simple {@link Fragment} subclass. Use the {@link AlarmWarningFragment#newInstance} factory
 * method to create an instance of this fragment.
 */
@AndroidEntryPoint
public class AlarmWarningFragment extends Fragment {

  public static final int TEN_SECONDS = 10000;
  private FragmentAlarmWarningBinding binding;
  private long currentTime;
  private long alarmTime;
  private long countdownTime;

  public AlarmWarningFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentAlarmWarningBinding.inflate(inflater, container, false);
    alarmTime = currentTimeMillis() + TEN_SECONDS;
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
    binding.countdown.addTextChangedListener((CountdownWatcher) this::countdown);
  }

  public void countdown(Editable editable){
    countdownTime = alarmTime - currentTimeMillis();
    binding.countdown.setText(String.valueOf(countdownTime));
  }

  private interface CountdownWatcher extends TextWatcher {

    @Override
    default void beforeTextChanged(CharSequence s, int start, int count, int after) {
      // Do nothing.
    }

    @Override
    default void onTextChanged(CharSequence s, int start, int before, int count) {
      // Do nothing.
    }
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

}