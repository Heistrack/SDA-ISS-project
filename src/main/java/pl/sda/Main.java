package pl.sda;


import org.json.simple.JSONObject;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Connection connection = new Connection();
        connection.getStaLoc();
////        connection.getPeople();
//        System.out .println(connection.issPeopleParser());

//        SpacePeopleRepository spacePeopleRepository = new SpacePeopleRepository();
//        spacePeopleRepository.addSpacePeopleToDB(connection.issPeopleParser());
//        spacePeopleRepository.loadSpacePeople().stream().forEach(System.out::println);
        CalClass c = new CalClass();
        System.out.println(c.getVelocity());


//        GUI gui = new GUI();
//        System.out.println("hello");
//        gui.showGUI();
    }
}
