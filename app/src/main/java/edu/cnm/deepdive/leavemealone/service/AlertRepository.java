package edu.cnm.deepdive.leavemealone.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.leavemealone.model.dao.AlertDao;
import edu.cnm.deepdive.leavemealone.model.entity.Alert;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;

public class AlertRepository {

  private final AlertDao alertDao;


  public AlertRepository(AlertDao alertDao) {
    this.alertDao = alertDao;
  }

  public Single<Long> add(Alert alert){
    return alertDao
        .insert(alert)
        .subscribeOn(Schedulers.io());
  }

  public LiveData<List<Alert>> getAll() {
    return alertDao.getAlerts();
  }

  public LiveData<List<Alert>> getAllTriggeredOrNotTriggered(boolean triggered) {
    return alertDao.getAlertsTriggeredOrNotTriggered(triggered);
  }

  public Completable clearAll() {
    return alertDao.truncateAlerts();
  }

  public Completable clearOneTriggered(long alert_id) {
    return alertDao.truncateAlertTriggered(alert_id);
  }

  public Completable clearAllTriggered() {
    return alertDao.truncateAlertsTriggered();
  }

}
