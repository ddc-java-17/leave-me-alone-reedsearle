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
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.databinding.FragmentAlarmWarningBinding;
import edu.cnm.deepdive.leavemealone.viewmodel.AlertViewModel;

/**
 * A simple {@link Fragment} subclass. Use the {@link AlarmWarningFragment#newInstance} factory
 * method to create an instance of this fragment.
 */
@AndroidEntryPoint
public class AlarmWarningFragment extends Fragment {

  private FragmentAlarmWarningBinding binding;
  private AlertViewModel viewModel;

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
    ViewModelProvider provider = new ViewModelProvider(this);
    viewModel = provider.get(AlertViewModel.class);
    getLifecycle().addObserver(viewModel);
    LifecycleOwner owner = getViewLifecycleOwner();
    viewModel.startTimer();
    viewModel.getTimeRemaining()
        .observe(owner, (time) -> binding.countdown.setText(String.valueOf(time)));
    viewModel.getTimeExpired()
        .observe(owner, (expired) -> {
          if (expired) {
            navController.navigate(ControlsFragmentDirections.navigateSounding());
          }
        });
    binding.disarmAlarm.setOnClickListener(
        (v) -> navController.navigate(ControlsFragmentDirections.navigateControls()));
  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

}