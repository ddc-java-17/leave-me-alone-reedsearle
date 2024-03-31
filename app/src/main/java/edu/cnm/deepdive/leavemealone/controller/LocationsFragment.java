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
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.leavemealone.adapter.LocationsAdapter;
import edu.cnm.deepdive.leavemealone.databinding.FragmentLocationsBinding;
import edu.cnm.deepdive.leavemealone.viewmodel.LocationViewModel;

@AndroidEntryPoint
public class LocationsFragment extends Fragment {

  private FragmentLocationsBinding binding;
  private LocationViewModel viewModel;

  public static LocationsFragment newInstance() {
    return new LocationsFragment();
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentLocationsBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ViewModelProvider provider = new ViewModelProvider(this);
    viewModel = provider.get(LocationViewModel.class);
    LifecycleOwner owner = getViewLifecycleOwner();
    viewModel
        .getLocation()
        .observe(owner, (locations) -> {
          LocationsAdapter adapter = new LocationsAdapter(requireContext(), locations);
          binding.locationsResult.setAdapter(adapter);
        });
  }
  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }

}