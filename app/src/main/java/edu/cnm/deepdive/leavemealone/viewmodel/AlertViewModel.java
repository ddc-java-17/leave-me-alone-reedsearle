package edu.cnm.deepdive.leavemealone.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import edu.cnm.deepdive.leavemealone.service.AlertRepository;
import javax.inject.Inject;


@HiltViewModel
public class AlertViewModel extends ViewModel {

  private final AlertRepository repository;
  private final MutableLiveData<Long> timerStep;

  @Inject
  public AlertViewModel(AlertRepository repository, MutableLiveData<Long> timerStep) {
    this.repository = repository;
    this.timerStep = timerStep;
  }

  public LiveData<Long> countdownTimer() {
    return repository.getCountdownTimer();
  }
}
