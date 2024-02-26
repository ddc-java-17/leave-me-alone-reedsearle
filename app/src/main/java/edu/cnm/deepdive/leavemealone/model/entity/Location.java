package edu.cnm.deepdive.leavemealone.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.leavemealone.model.GPSCoord;

@Entity(
    tableName = "location",
    indices = {
        @Index(value = "secure", unique = true),
        @Index(value = "coordinate", unique = true)
    }

)
public class Location {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "location_id")
    private long id;

    @ColumnInfo(name = "secure", index = true)
    private boolean secure;

    @ColumnInfo(name = "coordinate", index = true)
    private GPSCoord gpsCoord;

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

    public GPSCoord getGpsCoord() {
        return gpsCoord;
    }

    public void setGpsCoord(GPSCoord gpsCoord) {
        this.gpsCoord = gpsCoord;
    }
}
