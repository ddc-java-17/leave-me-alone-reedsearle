package edu.cnm.deepdive.leavemealone.model.pojo;

/**
 * This a record file to create a class for GPS coordinates
 * @param latitude
 * @param longitude
 */
public record GPSCoord(double latitude, double longitude) {

  /**
   * This constructor link the coordinates with the record
   * @param latitude
   * @param longitude
   */
  public GPSCoord(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
