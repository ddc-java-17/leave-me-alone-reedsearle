package edu.cnm.deepdive.leavemealone.viewmodel;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;

public class MotionViewModel {

private MotionTriggerListener listener;

  public MotionViewModel() {
    listener = new MotionTriggerListener();
  }


  class MotionTriggerListener extends TriggerEventListener{
    private final SensorManager sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE, );
    private final Sensor sensor= sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);

    @Override
    public void onTrigger(TriggerEvent event) {

    }
  }

}
