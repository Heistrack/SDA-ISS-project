package pl.sda;

import java.util.Scanner;

public class GUI {


    void showGUI(){
        Calculations calculations = new Calculations();
        Scanner myScanner = new Scanner(System.in);
        SpacePeopleRepository spacePeopleRepository = new SpacePeopleRepository();
        Connection connection = new Connection();
        StationLocalisationRepository stationLocalisationRepository = new StationLocalisationRepository();


        while (true){
            System.out.println("1. Pokaż osoby aktualnie przebywające na ISS");
            System.out.println("2. Pokaż aktualną prędkośc ISS");
            System.out.println("3. Pokaż aktualną lokalizację ISS");
            System.out.println("4. Wyjdź");

            int choice = myScanner.nextInt();

            if (choice == 1){
                //metoda
                spacePeopleRepository.addSpacePeopleToDB(connection.issPeopleParser());
                spacePeopleRepository.loadSpacePeople().stream().forEach(System.out::println);

            }
            else if (choice == 2){
                //metoda
                System.out.println("wybor 2");
            }
            else if (choice == 3){
                //metoda
                stationLocalisationRepository.addStationLocalisationToDB(connection.issLocalParse());
                double lattitude = stationLocalisationRepository.loadStationLocalisation().latitude;
                double longitude = stationLocalisationRepository.loadStationLocalisation().longitude;
                System.out.println("Szerokość geograficzna: " + lattitude);
                System.out.println("Długość geograficzna: " + longitude);

            }
            else if (choice == 4){
                break;
            }
        }
    }
}
