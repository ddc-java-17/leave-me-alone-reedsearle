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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isTriggered() {
    return triggered;
  }

  public void setTriggered(boolean triggered) {
    this.triggered = triggered;
  }

  @NonNull
  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NonNull Instant timestamp) {
    this.timestamp = timestamp;
  }

  public String getPhotoname() {
    return photoname;
  }

  public void setPhotoname(String photoname) {
    this.photoname = photoname;
  }
}
