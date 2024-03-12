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
  String LOCATION_QUERY_FOR_SECURE = "SELECT * FROM location WHERE secure = :secure";
  String LOCATION_QUERY_FOR_TRACKING = "SELECT * FROM location WHERE tracked = true ORDER BY timestamp asc";
  String LOCATION_QUERY_FOR_TIME_AND_SECURE = "SELECT * FROM location WHERE timestamp > :hourStart AND timestamp < :hourStop AND secure = :secure";
  String TRUNCATION_QUERY_ONE = "DELETE FROM location WHERE location_id = :location_id OR secure = :secure OR tracked = :tracked";
  String TRUNCATION_QUERY_ALL = "DELETE FROM location";

  @Insert
  Single<Long> insert(Location location);

  @Update
  Completable update(Location location);

  @Query(LOCATION_QUERY)
  LiveData<List<Location>> getLocation();

  @Query(LOCATION_QUERY_FOR_SECURE)
  LiveData<List<Location>> getLocation(boolean secure);

  @Query(LOCATION_QUERY_FOR_TRACKING)
  LiveData<List<Location>> getLocationTracking();

  @Query(LOCATION_QUERY_FOR_TIME_AND_SECURE)
  LiveData<List<Location>> getLocation(Instant hourStart, Instant hourStop, boolean secure);

  @Query(TRUNCATION_QUERY_ALL)
  Completable truncateLocation();

  @Query(TRUNCATION_QUERY_ONE)
  Completable truncateLocation(long location_id, boolean secure, boolean tracked);
}
