package edu.cnm.deepdive.leavemealone.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.leavemealone.model.pojo.GPSCoord;
import java.time.Instant;

@Entity(
    tableName = "location",
    indices = {})
public class Location {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "location_id")
    private long id;

    @ColumnInfo(name = "secure", index = true)
    private boolean secure;

    @ColumnInfo(name = "tracked", index = true)
    private boolean tracked;

    @Embedded
    private GPSCoord gpsCoord;

    @ColumnInfo(name = "timestamp", index = true)
    @NonNull
    private Instant timestamp = Instant.now();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public boolean isTracked() {
        return tracked;
    }

    public void setTracked(boolean tracked) {
        this.tracked = tracked;
    }

    public GPSCoord getGpsCoord() {
        return gpsCoord;
    }

    public void setGpsCoord(GPSCoord gpsCoord) {
        this.gpsCoord = gpsCoord;
    }

    @NonNull
    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull Instant timestamp) {
        this.timestamp = timestamp;
    }
}
