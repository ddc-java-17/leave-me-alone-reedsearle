package edu.cnm.deepdive.leavemealone.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.leavemealone.model.dao.AlertDao;
import edu.cnm.deepdive.leavemealone.model.entity.Alert;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AlertRepository {

  private final AlertDao alertDao;
  private Timer countdownTimer;
//  private final TimerTask timerTask;


  public AlertRepository(AlertDao alertDao) {
    this.alertDao = alertDao;
  }

  public Single<Long> add(Alert alert){
    return alertDao
        .insert(alert)
        .subscribeOn(Schedulers.io());
  }

//  public LiveData<Timer> getCountdownTimer() {
//    return countdownTimer.scheduleAtFixedRate(run(), 0, 1000);
//  }

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
