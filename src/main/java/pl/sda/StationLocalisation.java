package pl.sda;

import javax.persistence.*;

@Entity
public class StationLocalisation {

    @Id
    @Column(name = "Station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int stationID;

    @Column(name = "timestamp")
    long timeStamp;

    @Column(name = "Latitude")
    double latitude;

    @Column(name = "Longitude")
    double longitude;


    public long getTimeStamp() {
        return timeStamp;
    }


    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "StationLocalisation{" +
                "stationID=" + stationID +
                ", timeStamp=" + timeStamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
