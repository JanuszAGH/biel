package pl.janusz.subramaniam.streams;

import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample11 {

    public static void main(String[] args) {

        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);
    }
}
