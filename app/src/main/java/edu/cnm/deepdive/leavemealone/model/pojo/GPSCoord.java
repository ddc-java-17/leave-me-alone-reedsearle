package edu.cnm.deepdive.leavemealone.model.pojo;

public record GPSCoord(double latitude, double longitude) {

  public GPSCoord(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
