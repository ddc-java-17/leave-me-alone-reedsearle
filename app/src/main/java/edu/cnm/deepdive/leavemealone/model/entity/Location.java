package edu.cnm.deepdive.leavemealone.model.entity;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    @ColumnInfo(name = "alert_id")
    @Nullable
    private long alertId;

    @ColumnInfo(name = "secure", index = true)
    private boolean secure;

    @Embedded
    private GPSCoord gpsCoord;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAlertId() {
        return alertId;
    }

    public void setAlertId(long alertId) {
        this.alertId = alertId;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public GPSCoord getGpsCoord() {
        return gpsCoord;
    }

    public void setGpsCoord(GPSCoord gpsCoord) {
        this.gpsCoord = gpsCoord;
    }
}
