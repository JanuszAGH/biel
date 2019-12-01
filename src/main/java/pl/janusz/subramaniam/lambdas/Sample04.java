package pl.janusz.subramaniam.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample04 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = numbers.stream()
                .map(e -> 2 * e)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
