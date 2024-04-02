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

    /**
     * Returns the id of a particular location
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * This annotates an individual location with an id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * This returns the alert_id of a particular location
     * @return
     */
    public long getAlertId() {
        return alertId;
    }

    /**
     * This annotates an individual location with its associated alert_id
     * @param alertId
     */
    public void setAlertId(long alertId) {
        this.alertId = alertId;
    }

    /**
     * This returns the secure status of a location
     * @return
     */
    public boolean isSecure() {
        return secure;
    }

    /**
     * This annotates a location with a boolena secure status
     * @param secure
     */
    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    /**
     * This returns the GPS coordinates of a location
     *
     * @return
     */
    public GPSCoord getGpsCoord() {
        return gpsCoord;
    }

    /**
     * This annotates a location with a set of GPS coordinates
     * @param gpsCoord
     */
    public void setGpsCoord(GPSCoord gpsCoord) {
        this.gpsCoord = gpsCoord;
    }
}
