package pl.janusz.subramaniam.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample10 {

    public static void main(String[] args) {

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream.of(integers)
                .forEach(System.out::println);
    }
}
