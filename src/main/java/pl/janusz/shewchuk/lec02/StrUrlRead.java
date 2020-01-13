package pl.janusz.shewchuk.lec02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 07/01/2020. Project; bielmarcus
 */
public class StrUrlRead {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.example.com");
        StringBuilder sb = new StringBuilder();
        String line = null;
        int counter = 0;

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(++counter + ": ");
            sb.append(line);
            sb.append("\n");
        }
        System.out.println(sb.toString());

//        System.out.println(bufferedReader.lines().collect(Collectors.joining("\n")));
    }
}
