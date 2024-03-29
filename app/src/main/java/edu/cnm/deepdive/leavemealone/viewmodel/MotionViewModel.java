package edu.cnm.deepdive.leavemealone.viewmodel;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.time.Instant;
import javax.inject.Inject;

@HiltViewModel
public class MotionViewModel extends ViewModel{

  private final MutableLiveData<TriggerEvent> triggerEvent;
  private final MotionTriggerListener listener;

  @Inject
  public MotionViewModel(Context context) {
    listener = new MotionTriggerListener(context);
    triggerEvent = new MutableLiveData<>();
  }

  public MutableLiveData<TriggerEvent> getTriggerEvent() {
    listener.onTrigger(triggerEvent);
    return triggerEvent;
  }

   MotionTriggerListener getListener() {
    return listener;
  }

  static class MotionTriggerListener extends TriggerEventListener{

    private final SensorManager sensorManager;
    private final Sensor sensor;
    public MotionTriggerListener(Context context) {
      sensorManager= (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
      sensor= sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);
    }

    @Override
    public void onTrigger(TriggerEvent event) {
      event.timestamp = Long.parseLong(String.valueOf(Instant.now()));
    }
  }

}
