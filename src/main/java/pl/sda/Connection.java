package pl.sda;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Connection {

    public JSONObject getStaLoc() {

        try {

            URL url = new URL("http://api.open-notify.org/iss-now.json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();

                JSONParser parse = new JSONParser();
                Object dataObject = parse.parse(String.valueOf(informationString));

                System.out.println(dataObject);

                JSONObject stationLoc = (JSONObject) dataObject;

                return stationLoc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getPeople() {
        try {

            URL url = new URL("http://api.open-notify.org/astros.json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();

                JSONParser parse = new JSONParser();
                Object dataObject = parse.parse(String.valueOf(informationString));

                System.out.println(dataObject);

                JSONObject statPeople = (JSONObject) dataObject;

                return statPeople;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public StationLocalisation issLocalParse() {
        Connection conn = new Connection();
        org.json.JSONObject jsonObject = new org.json.JSONObject(conn.getStaLoc());

        StationLocalisation sT = new StationLocalisation();

        sT.setLatitude(jsonObject.getJSONObject("iss_position").getDouble("latitude"));
        sT.setLongitude(jsonObject.getJSONObject("iss_position").getDouble("longitude"));
        sT.setTimeStamp(jsonObject.getLong("timestamp"));

        return sT;
    }

    public ArrayList<SpacePeople> issPeopleParser() {
        ArrayList<SpacePeople> peopleArr = new ArrayList<>();

        Connection conn = new Connection();
        org.json.JSONObject obj = new org.json.JSONObject(conn.getPeople());
        org.json.JSONArray arr = obj.getJSONArray("people");

        for (int i = 0; i < arr.length(); i++) {
            if (arr.getJSONObject(i).getString("craft").equals("ISS")) {

                SpacePeople people1 = new SpacePeople();
                people1.setName(arr.getJSONObject(i).getString("name"));
                people1.setCraft(arr.getJSONObject(i).getString("craft"));

                peopleArr.add(people1);
            }
        }
        return peopleArr;
    }
}
