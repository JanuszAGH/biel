package pl.janusz.techprimers.pt01;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class ExampleM {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

        names
                .stream()
                .filter("Sam"::equalsIgnoreCase) 
                .forEach(System.out::println);
    }
}
