package pl.sda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpacePeople {

    @Id
    @Column(name = "Station_id")
    private int personID;

    @Column(name = "name")
    private String name;

    @Column(name = "craft")
    private String craft;
}
