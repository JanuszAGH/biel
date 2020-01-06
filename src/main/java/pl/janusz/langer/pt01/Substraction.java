package pl.janusz.langer.pt01;

import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class Substraction {

    public static void main(String[] args) {

        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Stream.of(numbers)
//                .parallel()
                .reduce(0, (a, e) -> a - e));

        System.out.println(Stream.of(numbers)
                .parallel()
                .reduce(0, (a, e) -> a - e));

        System.out.println(Stream.of(numbers)
//                .parallel()
                .reduce(0, (a, e) -> a + e));

        System.out.println(Stream.of(numbers)
                .parallel()
                .reduce(0, (a, e) -> a + e));
    }
}
