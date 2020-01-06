package pl.janusz.techprimers.pt01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class FromFile {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src", "main", "resources", "files");
        Path resolve = path.resolve(Paths.get("employees.xml"));

        Files.lines(resolve).forEach(System.out::println);
    }
}
