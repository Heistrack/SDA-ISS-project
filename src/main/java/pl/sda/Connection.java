package pl.sda;

import org.json.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
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

    public String[] issLocalParse(JSONObject obj) {
        Connection conn = new Connection();
        org.json.JSONObject jsonObject = new org.json.JSONObject(obj);

        String[] strings = new String[3];

        strings[0] = jsonObject.getJSONObject("iss_position").getString("latitude");
        strings[1] = jsonObject.getJSONObject("iss_position").getString("longitude");
        strings[2] = String.valueOf(jsonObject.getLong("timestamp"));

        return strings;
    }

    public ArrayList<People> issPeopleParser(JSONObject jsonObject) {
        ArrayList<People> peopleArr = new ArrayList<>();

        Connection conn = new Connection();
        org.json.JSONObject obj = new org.json.JSONObject(jsonObject);
        org.json.JSONArray arr = obj.getJSONArray("people");

        for (int i = 0; i < arr.length(); i++) {
            if (arr.getJSONObject(i).getString("craft").equals("ISS")) {

                People people1 = new People(arr.getJSONObject(i).getString("name"),
                        arr.getJSONObject(i).getString("craft"));

                peopleArr.add(people1);
            }
        }
        return peopleArr;
    }
}
