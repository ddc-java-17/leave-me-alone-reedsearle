package edu.cnm.deepdive.leavemealone.service;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.leavemealone.model.dao.AlertDao;
import edu.cnm.deepdive.leavemealone.model.entity.Alert;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AlertRepository {

  private final AlertDao alertDao;
  private final PreferencesRepository repository;

  @Inject
  public AlertRepository(AlertDao alertDao, PreferencesRepository repository) {
    this.alertDao = alertDao;
    this.repository = repository;
  }

  public Observable<Long> getCountdownTimer(int countdownDelay) {
    return Observable
        .intervalRange(0, countdownDelay, 0, 1, TimeUnit.SECONDS, Schedulers.single())
        .map((value) -> 10 - value);
  }

  public boolean checkPassword(String enteredPassword) {
    return repository.getPassword().equals(enteredPassword);
  }


  public Single<Long> add(Alert alert) {
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
