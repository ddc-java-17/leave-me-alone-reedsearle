package edu.cnm.deepdive.leavemealone.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;
import edu.cnm.deepdive.leavemealone.service.LocationRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.List;
import javax.inject.Inject;

@HiltViewModel
public class LocationViewModel extends ViewModel {

  private final LocationRepository repository;
  private final LiveData<List<Location>> location;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  @Inject
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

  public void markLocation(boolean secure) {
    throwable.setValue(null);
//    repository.
    // TODO: 3/30/2024 Invoke actuial method in repositiory
  }

  // TODO: Implement the ViewModel
}