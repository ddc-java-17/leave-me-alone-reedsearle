package edu.cnm.deepdive.leavemealone.model;

import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;
import java.net.URI;
import java.time.Instant;
import java.util.List;

public class Alert {

  private boolean triggered;
  private URI photo; // TODO: 2/15/2024 List of photos? Video? 
  private final Instant timeOn;
  private  Instant timeOff;

  private List<GPSCoord> coordList;

  // TODO: 2/15/2024 Need field for initial value of the sensors 

  private Alert(Instant timeOn) {
    this.timeOn = timeOn;
    triggered = false;
    photo = null;
    timeOff = null;
    // TODO: 2/15/2024 Initialize the sensors 
  }



  public void disarm() {
    setTimeOff(Instant.now());
    // TODO: 2/12/2024 Add method to disarm alarm
  }

  public void setTimeOff(Instant timeOff) {
    this.timeOff = timeOff;
  }
}
