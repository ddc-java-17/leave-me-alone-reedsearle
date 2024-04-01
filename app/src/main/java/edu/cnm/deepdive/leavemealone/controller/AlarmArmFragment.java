package edu.cnm.deepdive.leavemealone.controller;

import android.os.Bundle;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmArmBinding;
import edu.cnm.deepdive.leavemealone.util.PasswordWatcher;
import edu.cnm.deepdive.leavemealone.viewmodel.AlertViewModel;
import edu.cnm.deepdive.leavemealone.viewmodel.MotionViewModel;

/**
 * A simple {@link Fragment} subclass. Use the {@link AlarmArmFragment#newInstance} factory method
 * to create an instance of this fragment.
 */
@AndroidEntryPoint
public class AlarmArmFragment extends Fragment {

  public static final int PASSWORD_DIGIT_LENGTH = 4;
  public static final int RESET_CODE_LENGTH = 0;

  private FragmentAlarmArmBinding binding;
  private MotionViewModel motionViewModel;
  private AlertViewModel alertViewModel;
  private int codeLength;

  public AlarmArmFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    codeLength = RESET_CODE_LENGTH;
    binding = FragmentAlarmArmBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    NavController navController = Navigation.findNavController(view);
    ViewModelProvider provider = new ViewModelProvider(this);
    motionViewModel = provider.get(MotionViewModel.class);
    alertViewModel = provider.get(AlertViewModel.class);
    LifecycleOwner owner = getViewLifecycleOwner();
    motionViewModel.getTriggerEvent().observe(owner,
        (b) -> {
          navController.navigate(AlarmArmFragmentDirections.navigateWarning());
        });
    binding.textCode.addTextChangedListener((PasswordWatcher) s -> {
      codeLength++;
      if (codeLength == PASSWORD_DIGIT_LENGTH) {
        String inputCode = s.toString();
        if(alertViewModel.checkPassword(inputCode)){
          navController.navigate(AlarmArmFragmentDirections.navigateControls());
        }
        binding.textCode.setText("");
        codeLength = RESET_CODE_LENGTH;
      }
    });
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }



}