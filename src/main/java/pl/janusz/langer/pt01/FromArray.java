package pl.janusz.langer.pt01;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class FromArray {

    public static void main(String[] args) {

        Integer[] number = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream.of(number)
                .forEach(System.out::println);

        System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallel().sum());


    }
}
