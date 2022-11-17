package pl.sda;

public class People {

    private String name;
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

    public People(String name, String craft) {
        this.name = name;
        this.craft = craft;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", craft='" + craft + '\'' +
                '}';
    }
}
