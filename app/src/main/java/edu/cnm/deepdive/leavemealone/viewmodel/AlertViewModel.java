package edu.cnm.deepdive.leavemealone.viewmodel;

import android.app.PendingIntent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import edu.cnm.deepdive.leavemealone.service.AlertRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import javax.inject.Inject;


@HiltViewModel
public class AlertViewModel extends ViewModel implements DefaultLifecycleObserver {

  private static final String TAG = AlertViewModel.class.getSimpleName();
  private final AlertRepository repository;
  private final MutableLiveData<Long> timerStep;
  private final MutableLiveData<Long> timeRemaining;
  private final MutableLiveData<Boolean> timeExpired;
  private final MutableLiveData<Boolean> passwordCorrect;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  @Inject
  public AlertViewModel(AlertRepository repository) {
    this.repository = repository;
    timerStep = new MutableLiveData<>();
    timeRemaining = new MutableLiveData<>();
    timeExpired = new MutableLiveData<>();
    passwordCorrect = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public void startTimer(){
    throwable.setValue(null);
    timeExpired.setValue(false);
    repository.getCountdownTimer()
        .subscribe(
            timeRemaining::postValue,
            this::postThrowable,
            ()-> timeExpired.postValue(true),
            pending
        );
  }

  public boolean checkPassword(String inputPassword){
    return repository.checkPassword(inputPassword);
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
