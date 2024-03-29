package edu.cnm.deepdive.leavemealone.viewmodel;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import javax.inject.Inject;

@HiltViewModel
public class MotionViewModel extends ViewModel implements DefaultLifecycleObserver{

  private final MutableLiveData<TriggerEvent> triggerEvent;
  private MotionTriggerListener listener;
  private final CompositeDisposable pending;


  @Inject
  public MotionViewModel(Context context) {
    listener = new MotionTriggerListener(context);
    triggerEvent = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public MutableLiveData<TriggerEvent> getTriggerEvent() {
    return triggerEvent;
  }

  public MotionTriggerListener getListener() {
    return listener;
  }

  public CompositeDisposable getPending() {
    return pending;
  }

  @Override
  public void onStop(@NonNull LifecycleOwner owner) {
    pending.clear();
    DefaultLifecycleObserver.super.onStop(owner);
  }


  class MotionTriggerListener extends TriggerEventListener{

    private final SensorManager sensorManager;
    private final Sensor sensor;
    public MotionTriggerListener(Context context) {
      sensorManager= (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
      sensor= sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);
    }

    @Override
    public void onTrigger(TriggerEvent event) {
      onTrigger(event);
    }
  }

}
