package pl.sda;

import javax.persistence.*;

@Entity
public class StationVelocity {

    @Id
    @Column(name = "measurent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int measurementID;

    @Column(name = "velocity")
    private int velocity;
}
