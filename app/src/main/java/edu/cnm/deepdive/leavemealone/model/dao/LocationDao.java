package edu.cnm.deepdive.leavemealone.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.time.Instant;
import java.util.List;

public interface LocationDao {

  String LOCATION_QUERY = "SELECT * FROM location";
  String LOCATION_QUERY_FOR_SECURE = "SELECT * FROM location WHERE secure = :secure";
  String LOCATION_QUERY_FOR_TRACKING = "SELECT * FROM location WHERE tracked = true";
  String LOCATION_QUERY_FOR_TIME = "SELECT * FROM location WHERE timestamp > :hourStart AND timestamp < :hourStop";
  String TRUNCATION_QUERY = "DELETE FROM location";

  @Insert
  Single<Long> insert(Location location);

  @Update
  Completable update(Location location);

  @Query(LOCATION_QUERY)
  LiveData<List<Location>> getLocation(Location location);

  @Query(LOCATION_QUERY_FOR_SECURE)
  LiveData<List<Location>> getLocation(Location location, boolean secure);

  @Query(LOCATION_QUERY_FOR_TRACKING)
  LiveData<List<Location>> getLocationTracking(Location location, boolean tracked);

  @Query(LOCATION_QUERY_FOR_TIME)
  LiveData<List<Location>> getLocation(Location location, Instant hourStart, Instant hourStop);

  @Query(TRUNCATION_QUERY)
  Completable truncateLocation();
}
