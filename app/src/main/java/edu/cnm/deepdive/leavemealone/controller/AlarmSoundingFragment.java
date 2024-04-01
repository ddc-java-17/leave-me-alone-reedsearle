package edu.cnm.deepdive.leavemealone.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmSoundingBinding;
import edu.cnm.deepdive.leavemealone.util.PasswordWatcher;
import edu.cnm.deepdive.leavemealone.viewmodel.AlertViewModel;

/**
 * A simple {@link Fragment} subclass. Use the {@link AlarmSoundingFragment#newInstance} factory
 * method to create an instance of this fragment.
 */
@AndroidEntryPoint
public class AlarmSoundingFragment extends Fragment {

  public static final int PASSWORD_DIGIT_LENGTH = 4;
  public static final int RESET_CODE_LENGTH = 0;
  private AlertViewModel viewModel;
  private int codeLength;
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
    NavController navController = Navigation.findNavController(view);
    ViewModelProvider provider = new ViewModelProvider(this);
    viewModel = provider.get(AlertViewModel.class);
    getLifecycle().addObserver(viewModel);
    LifecycleOwner owner = getViewLifecycleOwner();
    binding.textCode.addTextChangedListener((PasswordWatcher) s -> {
      codeLength++;
      if (codeLength == PASSWORD_DIGIT_LENGTH) {
        String inputCode = s.toString();
        if(viewModel.checkPassword(inputCode)){
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