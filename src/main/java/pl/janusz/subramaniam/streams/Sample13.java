package pl.janusz.subramaniam.streams;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample13 {

    public static void main(String[] args) {

        Stream
                .generate(() -> ThreadLocalRandom.current().nextInt(100)).limit(10)
                .forEach(System.out::println);
    }
}
