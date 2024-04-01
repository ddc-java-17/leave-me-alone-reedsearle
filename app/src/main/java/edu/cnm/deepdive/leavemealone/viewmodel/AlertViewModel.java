package edu.cnm.deepdive.leavemealone.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@HiltViewModel
public class AlertViewModel extends ViewModel {

  @Inject
  public AlertViewModel() {
  }
}
