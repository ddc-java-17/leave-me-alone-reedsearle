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

  public static final int START_VALUE = 0;
  public static final int INITIAL_DELAY = 0;
  public static final int ONE_SECOND_PERIOD = 1;
  private final AlertDao alertDao;
  private final PreferencesRepository repository;

  /**
   * This repository links the view models to the countdown timer and the password checker
   * @param alertDao
   * @param repository
   */
  @Inject
  public AlertRepository(AlertDao alertDao, PreferencesRepository repository) {
    this.alertDao = alertDao;
    this.repository = repository;
  }

  /**
   * The getCountdownTimer method receives countdownDelay from the AlertViewModel and returns
   * both the countdown and a completion event to signal the countdown has ended
   * @param countdownDelay
   * @return
   */
  public Observable<Long> getCountdownTimer(int countdownDelay) {
    return Observable
        .intervalRange(START_VALUE, countdownDelay+1, INITIAL_DELAY, ONE_SECOND_PERIOD, TimeUnit.SECONDS, Schedulers.single())
        .map((value) -> countdownDelay - value);
  }

  /**
   * This method does the actual work of checking the password against the correct password stored
   * in the Preferences Repository
   * @param enteredPassword
   * @return
   */
  public boolean checkPassword(String enteredPassword) {
    return repository.getPassword().equals(enteredPassword);
  }

}
