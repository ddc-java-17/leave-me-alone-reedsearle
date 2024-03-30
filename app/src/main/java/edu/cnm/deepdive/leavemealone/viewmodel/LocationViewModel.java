package edu.cnm.deepdive.leavemealone.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;
import edu.cnm.deepdive.leavemealone.service.LocationRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class LocationViewModel extends ViewModel {

  private final LocationRepository repository;
  private final MutableLiveData<GPSCoord> location;
  private final MutableLiveData<Boolean> isSecure;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public LocationViewModel(LocationRepository repository) {
    this.repository = repository;
    isSecure = new MutableLiveData<>();
    location = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public LocationRepository getRepository() {
    return repository;
  }

  public LiveData<GPSCoord> getLocation() {
    return location;
  }

  public LiveData<Boolean> getIsSecure() {
    return isSecure;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  // TODO: Implement the ViewModel
}