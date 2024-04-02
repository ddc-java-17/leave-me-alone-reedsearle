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

/**
 * The LocationDao implements the queries necessary to interact with the Location entity in the
 * database
 */
@Dao
public interface LocationDao {

  String LOCATION_QUERY = "SELECT * FROM location";

  @Insert
  Single<Long> insert(Location location);

  @Query(LOCATION_QUERY)
  LiveData<List<Location>> getLocations();

}
