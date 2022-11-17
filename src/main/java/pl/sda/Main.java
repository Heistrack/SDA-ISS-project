package pl.sda;


import org.json.simple.JSONObject;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection();
        connection.getStaLoc();
        connection.getPeople();
        System.out.println(Arrays.asList(connection.issLocalParse()));
//        GUI gui = new GUI();
//        System.out.println("hello");
//        gui.showGUI();
    }
}
