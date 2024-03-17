package edu.cnm.deepdive.leavemealone.service;

import androidx.lifecycle.LiveData;
import androidx.room.Query;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.Instant;
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
  public LiveData<List<Location>> getAll(){
    return locationDao.getLocations();
  }
  public LiveData<List<Location>> getAllSecureOrUnsecure(boolean secure){
    return locationDao.getLocationsSecureOrUnsecure(secure);
  }
  public LiveData<List<Location>> getAllTracked(boolean tracked){
    return locationDao.getLocationsTracked(tracked);
  }
  public LiveData<List<Location>> getAllTimeframe(Instant hourStart, Instant hourStop, boolean secure){
    return locationDao.getLocationsTimeframe(hourStart, hourStop, secure);
  }
  public Completable clearAll() {
    return locationDao.truncateLocations();
  }
  public Completable clearSecure(long location_id) {
    return locationDao.truncateLocationSecure(location_id);
  }
  public Completable clearUnsecure(long location_id) {
    return locationDao.truncateLocationUnsecure(location_id);
  }
  public Completable clearAllSecures() {
    return locationDao.truncateLocationsSecure();
  }
  public Completable clearAllUnsecures() {
    return locationDao.truncateLocationsUnsecure();
  }
  public Completable clearAllTracked() {
    return locationDao.truncateLocationsTracked();
  }

}
