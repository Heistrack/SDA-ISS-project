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

    @Column(name = "Passes")
    int passes;

    @Column(name = "Latitude")
    double latitude;

    @Column(name = "Longitude")
    double longitude;

    @Column(name = "Altitude")
    double altitude;


}
