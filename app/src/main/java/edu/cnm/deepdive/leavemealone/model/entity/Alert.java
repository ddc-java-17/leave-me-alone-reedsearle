package edu.cnm.deepdive.leavemealone.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.net.URI;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Entity(
    tableName = "alert",
    indices = {}
)
public class Alert {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "alert_id")
  private long id;

  @ColumnInfo(name = "triggered", index = true)
  private boolean triggered;

  @ColumnInfo(name = "timestamp", index = true)
  @NonNull
  private Instant timestamp = Instant.now();

  private String photoname;

  /**
   * This returns the id of an individual alert
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * THis annotates an individual alert with a unique id
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * This returns a boolean value that show if a particular alert ended in being
   * triggered by motion
   * @return
   */
  public boolean isTriggered() {
    return triggered;
  }

  /**
   * This annotates an individual alert with a boolean value that represents if the
   * alert ended in being triggered by motion.
   * @param triggered
   */
  public void setTriggered(boolean triggered) {
    this.triggered = triggered;
  }

  /**
   * This returns the timestamp of when the alert was armed = NOTE this is not the time
   * a motion event was captured
   * @return
   */
  @NonNull
  public Instant getTimestamp() {
    return timestamp;
  }

  /**
   * This annotates an individual alert with the time is was armed
   * @param timestamp
   */
  public void setTimestamp(@NonNull Instant timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * This returns the filename of a photo, if one was taken
   * @return
   */
  public String getPhotoname() {
    return photoname;
  }

  /**
   * This annotates the alert with the filename of a photo that was taken
   * @param photoname
   */
  public void setPhotoname(String photoname) {
    this.photoname = photoname;
  }
}
