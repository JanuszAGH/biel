package pl.janusz.shewchuk.lec02;

import java.io.*;

/**
 * Created by Janusz Kacki on 07/01/2020. Project; bielmarcus
 */
public class StrInOut {

    public static void main(String[] args) {

        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = bufferedReader.readLine();
            bufferedWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
