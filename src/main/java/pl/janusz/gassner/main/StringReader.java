package pl.janusz.gassner.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Janusz Kacki on 16/11/2019. Project; bielmarcus
 */
public class StringReader {

    public static void main(String[] args) {

        final Path dir = Paths.get("src", "main", "resources", "files", "data");
        final Path largeXML = dir.resolve("customers.json");

        int c;
        final StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(largeXML.toFile()))) {
            while ((c = bufferedReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        final String result = stringBuilder.toString();
        System.out.println(result);
    }
}
