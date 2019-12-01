package pl.janusz.subramaniam.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public abstract class Sample03 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        String reduce = numbers.stream()
                .map(String::valueOf)
                .reduce("", String::concat);

        System.out.println(reduce);
    }
}
