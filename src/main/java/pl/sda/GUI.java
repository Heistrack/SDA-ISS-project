package pl.sda;

import java.util.Scanner;

public class GUI {


    void showGUI() throws InterruptedException {
        Connection conn = new Connection();
        Scanner myScanner = new Scanner(System.in);


        while (true){
            System.out.println("1. Pokaż osoby aktualnie przebywające na ISS");
            System.out.println("2. Pokaż aktualną prędkośc ISS");
            System.out.println("3. Pokaż listę nadchodzących przebiegow dla określonej lokalizacji");
            System.out.println("4. Wyjdź");

            int choice = myScanner.nextInt();

            if (choice == 1){
                //metoda
                System.out.println("wybor 1");
            }
            else if (choice == 2){
                //metoda
                StationVelocity sV = new StationVelocity();
                CalClass calClass = new CalClass();
                sV.setVelocity(calClass.getVelocity());
                StationVelocityRepository sVR = new StationVelocityRepository();
                sVR.sendStationVelocityToDB(sV);
                System.out.println("Prędkość wynosi: " + sVR.loadStationVelocity().getVelocity());
            }
            else if (choice == 3){
                //metoda
                System.out.println("wybor 3");
            }
            else if (choice == 4){
                break;
            }
        }
    }
}
