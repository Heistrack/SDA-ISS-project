package pl.sda;

import javax.persistence.*;

@Entity
public class SpacePeople {

    @Id
    @Column(name = "Station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personID;

    @Column(name = "name")
    private String name;

    @Column(name = "craft")
    private String craft;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }
}
