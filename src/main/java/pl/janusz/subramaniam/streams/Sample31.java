package pl.janusz.subramaniam.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample31 {

    public static void main(String[] args) {

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> collect = items
                .stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                );
    }
}
