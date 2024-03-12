package edu.cnm.deepdive.leavemealone.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class LocationRepository {

  private final LocationDao locationDao;

  @Inject
  public LocationRepository(LocationDao locationDao) {
    this.locationDao = locationDao;
  }


  public Single<Long> add(Location location){
    return locationDao
        .insert(location)
        .subscribeOn(Schedulers.io());
  }

  public LiveData<List<Location>> getAll(boolean secure){
    return locationDao.getLocation(secure);
  }

  public Completable clearAll() {
    return locationDao.truncateLocation();
  }

  public Completable clearAll(long location_id, boolean secure, boolean tracked) {
    return locationDao.truncateLocation(location_id, secure, tracked);
  }
}
