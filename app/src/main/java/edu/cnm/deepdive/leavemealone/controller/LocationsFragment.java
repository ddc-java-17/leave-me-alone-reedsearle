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
import edu.cnm.deepdive.leavemealone.databinding.FragmentLocationsBinding;
import edu.cnm.deepdive.leavemealone.viewmodel.LocationViewModel;

public class LocationsFragment extends Fragment {

  private FragmentLocationsBinding binding;
  private LocationViewModel viewModel;

  public static LocationsFragment newInstance() {
    return new LocationsFragment();
  }

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentLocationsBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

//  @Override
//  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//    super.onActivityCreated(savedInstanceState);
//    ViewModelProvider provider = new ViewModelProvider(this);
//    viewModel = provider.get(LocationViewModel.class);
//    LifecycleOwner owner = getViewLifecycleOwner();
//
//    // TODO: Use the ViewModel
//  }

}