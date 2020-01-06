package pl.janusz.subramaniam.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample09 {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 5, 4, 5, 1, 2, 3, 5, 4, 5, 1);

        System.out.println(numbers.stream()
                .distinct()
                .collect(Collectors.toList()));

        System.out.println(numbers.stream()
                .sorted()
                .collect(Collectors.toList()));

        System.out.println(numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList()));
    }
}
