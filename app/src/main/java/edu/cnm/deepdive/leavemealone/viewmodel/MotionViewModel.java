package edu.cnm.deepdive.leavemealone.viewmodel;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.time.Instant;
import javax.inject.Inject;

/**
 * Provides access for the UI to get motion information.  In this case, the trigger event
 * is just an event and no sensor data is sent/
 */
@HiltViewModel
public class MotionViewModel extends ViewModel{

  private final MutableLiveData<TriggerEvent> triggerEvent;
  private final MotionTriggerListener listener;

  /**
   * Provides the context for the sensor package
   * @param context
   */
  @Inject
  public MotionViewModel(@ApplicationContext Context context) {
    listener = new MotionTriggerListener(context);
    triggerEvent = new MutableLiveData<>();
  }

  /**
   * This is the interface for the UI to find motion events
   * @return
   */
  public LiveData<TriggerEvent> getTriggerEvent() {
    return triggerEvent;
  }

  class MotionTriggerListener extends TriggerEventListener{

    private final SensorManager sensorManager;
    private final Sensor sensor;

    /**
     * THis initializes the sensor package by getting a sensor service and setting is to
     * detect motion
     * @param context
     */
    public MotionTriggerListener(Context context) {
      sensorManager= (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
      sensor= sensorManager.getDefaultSensor(Sensor.TYPE_MOTION_DETECT);
      sensorManager.requestTriggerSensor(this, sensor);
    }

    /**
     * This sends the trigger event back to the UI
     * @param event The details of the event.
     */
    @Override
    public void onTrigger(TriggerEvent event) {
      event.timestamp = System.currentTimeMillis();
      MotionViewModel.this.triggerEvent.postValue(event);
    }
  }

}
