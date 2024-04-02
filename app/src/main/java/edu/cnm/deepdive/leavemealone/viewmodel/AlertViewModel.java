package edu.cnm.deepdive.leavemealone.viewmodel;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.service.AlertRepository;
import edu.cnm.deepdive.leavemealone.service.PreferencesRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * This provides an interface for the UI  to see countdown events, both individual ticks and the
 * completion event itself.  ALso this interfaces between the UI and the password checker
 */
@HiltViewModel
public class AlertViewModel extends ViewModel implements DefaultLifecycleObserver {

  private static final String TAG = AlertViewModel.class.getSimpleName();
  private final AlertRepository alertRepository;
  private final PreferencesRepository preferencesRepository;
  private final MutableLiveData<Long> timerStep;
  private final MutableLiveData<Long> timeRemaining;
  private final MutableLiveData<Boolean> timeExpired;
  private final MutableLiveData<Boolean> passwordCorrect;
  private final String countdownKey;
  private final int countdownDefault;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  /**
   * This initializes the interface between the UI and the repositories.  This also captures the
   * seekbar preference for countdown delay time
   * @param context
   * @param repository
   * @param preferencesRepository
   */
  @Inject
  public AlertViewModel(@ApplicationContext Context context, AlertRepository repository,
      PreferencesRepository preferencesRepository) {
    this.alertRepository = repository;
    this.preferencesRepository = preferencesRepository;
    timerStep = new MutableLiveData<>();
    timeRemaining = new MutableLiveData<>();
    timeExpired = new MutableLiveData<>();
    passwordCorrect = new MutableLiveData<>();
    countdownKey = context.getString(R.string.countdown_key);
    countdownDefault = context.getResources().getInteger(R.integer.countdown_default);
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  /**
   * This starts the countdown timer and sets its duration in seconds
   */
  public void startTimer(){
    int countdown = preferencesRepository.get(countdownKey, countdownDefault);
    throwable.setValue(null);
    timeExpired.setValue(false);
    alertRepository.getCountdownTimer(countdown)
        .subscribe(
            timeRemaining::postValue,
            this::postThrowable,
            ()-> timeExpired.postValue(true),
            pending
        );
  }

  /**
   * This check the disarm password
   * @param inputPassword
   * @return
   */
  public boolean checkPassword(String inputPassword){
    return alertRepository.checkPassword(inputPassword);
  }

  /**
   * This returns the amount of time remaining in the countdown.  This is returned to the UI for display
   * @return
   */
  public LiveData<Long> getTimeRemaining() {
    return timeRemaining;
  }

  /**
   * This returns the timer complete event in the form of a boolean
   * @return
   */
  public LiveData<Boolean> getTimeExpired() {
    return timeExpired;
  }

  /**
   * This returns the throwable for the subscribe
   * @return
   */
  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  @Override
  public void onStop(@NonNull LifecycleOwner owner) {
    pending.clear();
    DefaultLifecycleObserver.super.onStop(owner);

  }

  /**
   * This returns a log entry containing the class simple name, the error and the
   * entire throwable message
   * @param throwable
   */
  private void postThrowable(Throwable throwable){
    Log.e(TAG, throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }
}
