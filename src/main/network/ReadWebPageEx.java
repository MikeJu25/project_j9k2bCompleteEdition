package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class ReadWebPageEx {
    public static String getWelcomeLetter() throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String theURL = "https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html"; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();
            String welcomeLetter = sb.toString();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            return welcomeLetter;
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

    // EFFECTS: use apikey to get the weather information by printing a link to the weather report
    public static void getWeather() {
        String apikey = "90c5fff597152874eee403f77040518d";
        String londonWeatherQuery = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&mode=html&APPID=";
        String theURL = londonWeatherQuery + apikey;
        System.out.println(theURL);
    }
}



