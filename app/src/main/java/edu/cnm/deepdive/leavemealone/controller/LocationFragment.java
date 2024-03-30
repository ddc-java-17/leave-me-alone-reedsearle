package edu.cnm.deepdive.leavemealone.controller;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.databinding.FragmentLocationBinding;

public class LocationFragment extends Fragment {

  private FragmentLocationBinding binding;
  private LocationViewModel viewModel;

  public static LocationFragment newInstance() {
    return new LocationFragment();
  }

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentLocationBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    ViewModelProvider provider = new ViewModelProvider(this);
    viewModel = provider.get(LocationViewModel.class);
    getLifecycle().addObserver(viewModel);
    LifecycleOwner owner = getViewLifecycleOwner();

    // TODO: Use the ViewModel
  }

}