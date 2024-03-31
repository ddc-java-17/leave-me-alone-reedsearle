package edu.cnm.deepdive.leavemealone.service;

import static com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY;

import android.Manifest;
import android.Manifest.permission;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Query;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;
import edu.cnm.deepdive.leavemealone.viewmodel.LocationViewModel;
import edu.cnm.deepdive.leavemealone.viewmodel.PermissionsViewModel;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class LocationRepository implements FusedLocationProviderClient {

  private final LocationDao locationDao;
  private FusedLocationProviderClient fusedLocationProviderClient;
  private final PermissionsRepository repository;
  private final CancellationTokenSource cts;
  private edu.cnm.deepdive.leavemealone.model.entity.Location saveLocation;
  private GPSCoord coord;
  private boolean permissionChecked;
  private final LiveData<Boolean> locationPermissionGranted;


  @Inject
  public LocationRepository(@ApplicationContext Context context, LocationDao locationDao,
      PermissionsRepository repository) {
    this.locationDao = locationDao;
    this.repository = repository;
    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient();
    cts = new CancellationTokenSource();
    LiveData<Set<String>> distinctPermissions = Transformations.distinctUntilChanged(
        repository.getPermissions());
    locationPermissionGranted = Transformations.map(distinctPermissions, (permissions) -> {
      if (permissions.contains(permission.ACCESS_FINE_LOCATION)) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        fusedLocationProviderClient
            .getCurrentLocation(PRIORITY_HIGH_ACCURACY, cts.getToken())
            .addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
              @Override
              public void onSuccess(android.location.Location location) {

              }
            })
      }
    });
  }


  public Single<Long> add(Location location) {
    return locationDao
        .insert(location)
        .subscribeOn(Schedulers.io());
//        .setPositiveButton(R.string.set_secure_label, (dlg, which) -> {
//          if (permissionChecked) {
//            try {
//              fusedLocationProviderClient
//                  .getCurrentLocation(PRIORITY_HIGH_ACCURACY, cts.getToken())
//                  .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                      if (location != null) {
//                        coord.latitude() = location.getLatitude();
//                        coord.longitude() = location.getLongitude();
//                        saveLocation.setGpsCoord(coord);
//                        saveLocation.setSecure(true);
//                      }
//                    }
//                  });
//            } catch (SecurityException e) {
//              throw new RuntimeException(e);
//            }
//          }
//        })
  }


  public void setupViewModel() {
//    super.onStart();
//    ViewModelProvider provider = new ViewModelProvider(requireActivity());
//    viewModel = provider.get(PermissionsViewModel.class);
//    LifecycleOwner owner = getViewLifecycleOwner();
//    viewModel
//        .getPermissions()
//        .observe(owner, (permissions) -> {
//          if (permissions.contains(Manifest.permission.ACCESS_FINE_LOCATION)) {
//            permissionChecked = true;
//          }
//        });
  }


  @NonNull
  @Override
  public Task<android.location.Location> getLastLocation() {
    return null;
  }

  @NonNull
  @Override
  public Task<android.location.Location> getLastLocation(
      @NonNull LastLocationRequest lastLocationRequest) {
    return null;
  }

  @NonNull
  @Override
  public Task<android.location.Location> getCurrentLocation(int i,
      @Nullable CancellationToken cancellationToken) {
    return null;
  }

  @NonNull
  @Override
  public Task<android.location.Location> getCurrentLocation(
      @NonNull CurrentLocationRequest currentLocationRequest,
      @Nullable CancellationToken cancellationToken) {
    return null;
  }

  @NonNull
  @Override
  public Task<LocationAvailability> getLocationAvailability() {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest,
      @NonNull Executor executor, @NonNull LocationListener locationListener) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest,
      @NonNull LocationListener locationListener, @Nullable Looper looper) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest,
      @NonNull LocationCallback locationCallback, @Nullable Looper looper) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest,
      @NonNull Executor executor, @NonNull LocationCallback locationCallback) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest,
      @NonNull PendingIntent pendingIntent) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> removeLocationUpdates(@NonNull LocationListener locationListener) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> removeLocationUpdates(@NonNull LocationCallback locationCallback) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> removeLocationUpdates(@NonNull PendingIntent pendingIntent) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> flushLocations() {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> setMockMode(boolean b) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> setMockLocation(@NonNull android.location.Location location) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> requestDeviceOrientationUpdates(
      @NonNull DeviceOrientationRequest deviceOrientationRequest, @NonNull Executor executor,
      @NonNull DeviceOrientationListener deviceOrientationListener) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> requestDeviceOrientationUpdates(
      @NonNull DeviceOrientationRequest deviceOrientationRequest,
      @NonNull DeviceOrientationListener deviceOrientationListener, @Nullable Looper looper) {
    return null;
  }

  @NonNull
  @Override
  public Task<Void> removeDeviceOrientationUpdates(
      @NonNull DeviceOrientationListener deviceOrientationListener) {
    return null;
  }

  @NonNull
  @Override
  public ApiKey<NoOptions> getApiKey() {
    return null;
  }
}
