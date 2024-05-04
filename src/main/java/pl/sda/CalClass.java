package pl.sda;

public class CalClass {

    public double getVelocity() throws InterruptedException {
        StationLocalisationRepository sLR = new StationLocalisationRepository();
        Connection conn = new Connection();

        sLR.addStationLocalisationToDB(conn.issLocalParse());
        StationLocalisation sL1 = sLR.loadStationLocalisation();

        System.out.println("Proszę czekać trwa pomiar drogi ISS..");
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(2000);
        System.out.println(".");
        Thread.sleep(2000);
        System.out.println("Już prawie koniec");
        Thread.sleep(2000);
        System.out.println("Gotowe");

        sLR.addStationLocalisationToDB(conn.issLocalParse());
        StationLocalisation sL2 = sLR.loadStationLocalisation();

        //Road in km
        Double road = Math.sqrt(
                Math.pow((sL2.latitude - sL1.latitude), 2) + Math.pow((sL2.longitude - sL1.longitude), 2));
        road *= 111.196;
        //Time in hours
        double time = sL2.getTimeStamp() - sL1.getTimeStamp();
        time /= 3600;
        // Velocity
        return road / time;
    }
}
