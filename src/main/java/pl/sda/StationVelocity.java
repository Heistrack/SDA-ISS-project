package pl.sda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StationVelocity {

    @Id
    @Column(name = "measurent_id")
    private int measurementID;

    @Column(name = "velocity")
    private int velocity;
}
