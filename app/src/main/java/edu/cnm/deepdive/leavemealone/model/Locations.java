package edu.cnm.deepdive.leavemealone.model;

import java.util.ArrayList;
import java.util.List;

public class Locations {

  private final List<GPSCoord> unsecureList;

  private final List<GPSCoord> secureList;

  public Locations(){
    unsecureList = new ArrayList<>();
    secureList = new ArrayList<>();
  }

  public List<GPSCoord> getUnsecureList() {
    return unsecureList;
  }

  public List<GPSCoord> getSecureList() {
    return secureList;
  }
}
