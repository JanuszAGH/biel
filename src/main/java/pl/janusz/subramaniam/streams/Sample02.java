package pl.janusz.subramaniam.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample02 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ArrayList<Integer> collect = numbers
                .stream()
                .map(e -> 2 * e)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
    }
}
