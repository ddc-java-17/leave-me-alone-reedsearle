package edu.cnm.deepdive.leavemealone.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;
import edu.cnm.deepdive.leavemealone.service.LocationRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.List;

public class LocationViewModel extends ViewModel {

  private final LocationRepository repository;
  private final LiveData<List<Location>> location;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public LocationViewModel(LocationRepository repository) {
    this.repository = repository;
    location = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public LocationRepository getRepository() {
    return repository;
  }

  public LiveData<List<Location>> getLocation() {
    return location;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  // TODO: Implement the ViewModel
}