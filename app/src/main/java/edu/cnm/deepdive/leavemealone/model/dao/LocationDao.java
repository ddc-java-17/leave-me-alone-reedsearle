package edu.cnm.deepdive.leavemealone.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.time.Instant;
import java.util.List;

@Dao
public interface LocationDao {

  String LOCATION_QUERY = "SELECT * FROM location";
  String LOCATIONS_QUERY_FOR_SECURE = "SELECT * FROM location WHERE secure = :secure";
  String LOCATIONS_QUERY_FOR_TRACKING = "SELECT * FROM location WHERE tracked = :tracked ORDER BY timestamp asc";
  String LOCATIONS_QUERY_FOR_TIME_AND_SECURE = "SELECT * FROM location WHERE timestamp > :hourStart AND timestamp < :hourStop AND secure = :secure";
  String TRUNCATION_QUERY_ONE_SECURE = "DELETE FROM location WHERE location_id = :location_id AND secure = true";
  String TRUNCATION_QUERY_ONE_UNSECURE = "DELETE FROM location WHERE location_id = :location_id AND secure = false";
  String TRUNCATION_QUERY_ALL = "DELETE FROM location";
  String TRUNCATION_QUERY_ALL_SECURE = "DELETE FROM location WHERE secure = true";
  String TRUNCATION_QUERY_ALL_UNSECURE = "DELETE FROM location WHERE secure = false";
  String TRUNCATION_QUERY_ALL_TRACKED = "DELETE FROM location WHERE tracked = true";

  @Insert
  Single<Long> insert(Location location);
  @Query(LOCATION_QUERY)
  LiveData<List<Location>> getLocations();
  @Query(LOCATIONS_QUERY_FOR_SECURE)
  LiveData<List<Location>> getLocationsSecureOrUnsecure(boolean secure);
  @Query(LOCATIONS_QUERY_FOR_TRACKING)
  LiveData<List<Location>> getLocationsTracked(boolean tracked);
  @Query(LOCATIONS_QUERY_FOR_TIME_AND_SECURE)
  LiveData<List<Location>> getLocationsTimeframe(Instant hourStart, Instant hourStop, boolean secure);
  @Query(TRUNCATION_QUERY_ALL)
  Completable truncateLocations();
  @Query(TRUNCATION_QUERY_ALL_SECURE)
  Completable truncateLocationsSecure();
  @Query(TRUNCATION_QUERY_ALL_UNSECURE)
  Completable truncateLocationsUnsecure();
  @Query(TRUNCATION_QUERY_ALL_TRACKED)
  Completable truncateLocationsTracked();
  @Query(TRUNCATION_QUERY_ONE_SECURE)
  Completable truncateLocationSecure(long location_id);
  @Query(TRUNCATION_QUERY_ONE_UNSECURE)
  Completable truncateLocationUnsecure(long location_id);
}
