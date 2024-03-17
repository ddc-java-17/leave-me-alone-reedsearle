package edu.cnm.deepdive.leavemealone.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.leavemealone.model.entity.Alert;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

@Dao
public interface AlertDao {
  String ALERT_QUERY = "SELECT * FROM alert";
  String ALERT_QUERY_FOR_TRIGGERED_OR_NOT_TRIGGERED = "SELECT * FROM alert WHERE triggered = :triggered";
  String TRUNCATION_QUERY_ALL = "DELETE FROM alert";
  String TRUNCATION_QUERY_ALL_TRIGGERED = "DELETE FROM alert WHERE triggered = true";
  String TRUNCATION_QUERY_ONE_TRIGGERED = "DELETE FROM alert WHERE alert_id = :alert_id";

  @Insert
  Single<Long> insert(Alert alert);

  @Query(ALERT_QUERY)
  LiveData<List<Alert>> getAlerts();
  @Query(ALERT_QUERY_FOR_TRIGGERED_OR_NOT_TRIGGERED)
  LiveData<List<Alert>> getAlertsTriggeredOrNotTriggered(boolean triggered);
  @Query(TRUNCATION_QUERY_ALL)
  Completable truncateAlerts();
  @Query(TRUNCATION_QUERY_ALL_TRIGGERED)
  Completable truncateAlertsTriggered();
  @Query(TRUNCATION_QUERY_ONE_TRIGGERED)
  Completable truncateAlertTriggered(long alert_id);

}
