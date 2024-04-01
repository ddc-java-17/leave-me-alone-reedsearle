package edu.cnm.deepdive.leavemealone.service;

import static com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY;

import android.Manifest.permission;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
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
import com.google.android.gms.tasks.Task;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocationRepository implements FusedLocationProviderClient {

  public static final int GPS_UPDATE_INTERVAL_MS = 1000;
  private final LocationDao locationDao;
  private FusedLocationProviderClient fusedLocationProviderClient;
  private final Executor executor;
  private final PermissionsRepository permissionsRepository;
  private final PreferencesRepository preferencesRepository;
  private GPSCoord coord;
  private final LiveData<Boolean> locationPermissionGranted;


  @Inject
  public LocationRepository(@ApplicationContext Context context,
      LocationDao locationDao,
      PermissionsRepository permissionsRepository,
      PreferencesRepository preferencesRepository) {
    this.locationDao = locationDao;
    this.permissionsRepository = permissionsRepository;
    this.preferencesRepository = preferencesRepository;
    this.executor = Executors.newSingleThreadExecutor();
    this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);

    if (coord == null) {
      coord = preferencesRepository.getCoord();
    }

    LiveData<Set<String>> distinctPermissions = Transformations.distinctUntilChanged(
        permissionsRepository.getPermissions());
    locationPermissionGranted = Transformations.map(distinctPermissions, (permissions) -> {
      if (permissions.contains(permission.ACCESS_FINE_LOCATION)) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest request = new LocationRequest
            .Builder(PRIORITY_HIGH_ACCURACY, GPS_UPDATE_INTERVAL_MS)
            .build();
        try {  // get initial GPS locations
          fusedLocationProviderClient
              .getLastLocation()
              .addOnSuccessListener(location -> {
                coord = new GPSCoord(location.getLongitude(), location.getLatitude());
                preferencesRepository.setCoord(coord);
              });
        } catch (SecurityException e) {
          throw new RuntimeException(e);
        }
        try {  // get subsequent GPS locations
          fusedLocationProviderClient.requestLocationUpdates(request, executor,
              location -> {
                coord = new GPSCoord(location.getLongitude(), location.getLatitude());
                preferencesRepository.setCoord(coord);
              });
        } catch (SecurityException e) {
          throw new RuntimeException(e);
        }
      }
      return false;
    });
  }

  public Single<Long> add(Boolean secure) {
    Location location = new Location();
    location.setSecure(secure);
    location.setGpsCoord(coord);
    return locationDao
        .insert(location)
        .subscribeOn(Schedulers.io());
  }

  public LiveData<List<Location>> getAll() {
    return locationDao.getLocations();
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
