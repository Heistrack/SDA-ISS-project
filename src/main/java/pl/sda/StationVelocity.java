package pl.sda;

import javax.persistence.*;

@Entity
public class StationVelocity {

    @Id
    @Column(name = "measurent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int measurementID;

    @Column(name = "velocity")
    private double velocity;


    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }



    @Override
    public String toString() {
        return "StationVelocity{" +
                "measurementID=" + measurementID +
                ", velocity=" + velocity +
                '}';
    }
}
