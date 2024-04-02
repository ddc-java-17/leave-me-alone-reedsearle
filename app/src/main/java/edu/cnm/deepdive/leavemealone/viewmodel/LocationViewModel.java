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

/**
 * This viewmodel provides an interface between the UI and the Location Repository.
 * This is used to send a request to store amd mark a location as secure as well as
 * provide the UI with locations to display
 *
 */
@HiltViewModel
public class LocationViewModel extends ViewModel {

  private final LocationRepository repository;
  private final LiveData<List<Location>> location;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  /**
   * This viewmodel is intialized with the locaiton repository and defines
   * the location, a throwable and a disposable
   * @param repository
   */
  @Inject
  public LocationViewModel(LocationRepository repository) {
    this.repository = repository;
    location = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  /**
   * This retrieves all locations stored in the Location entity
   * @return
   */
  public LiveData<List<Location>> getLocation() {
    return repository.getAll();
  }

  /**
   * This sets a location with a marker indicating if the location is secure
   * @param secure
   */
  public void markLocation(boolean secure) {
    throwable.setValue(null);
    repository.add(secure).subscribe();
  }

  /**
   * This returns a throwable
   * @return
   */
  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

}