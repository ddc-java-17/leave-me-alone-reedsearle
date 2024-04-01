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

  public boolean checkPassword(String inputPassword){
    return alertRepository.checkPassword(inputPassword);
  }

  public LiveData<Long> getTimeRemaining() {
    return timeRemaining;
  }

  public LiveData<Boolean> getTimeExpired() {
    return timeExpired;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public LiveData<Boolean> getPasswordCorrect() {
    return passwordCorrect;
  }

  @Override
  public void onStop(@NonNull LifecycleOwner owner) {
    pending.clear();
    DefaultLifecycleObserver.super.onStop(owner);

  }

  private void postThrowable(Throwable throwable){
    Log.e(TAG, throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }
}
