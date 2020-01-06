package pl.janusz.techprimers.pt01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class ExampleFE {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "B", "C", "C", "C");

        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()
                )));

        System.out.println(list.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.toList()
                )));
    }
}
