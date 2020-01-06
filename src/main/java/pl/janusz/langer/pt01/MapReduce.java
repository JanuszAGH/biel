package pl.janusz.langer.pt01;

import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class MapReduce {

    public static void main(String[] args) {

        String[] words = new String[]{
                "Alice", "in", "Wonderland", "the", "Cat", "Alice", "in", "Wonderland", "the", "Cat"};

        System.out.println(
                Stream.of(words)
//                        .parallel()
                        .reduce(0, (a, s) -> a + s.length(), (a, e) -> a + e)
        );

        System.out.println(
                Stream.of(words)
//                        .parallel()
                        .mapToInt(String::length)
                        .sum()
        );
        System.out.println(
                Stream.of(words)
                        .parallel()
                        .reduce(0, (a, s) -> a + s.length(), (a, e) -> a + e)
        );

        System.out.println(
                Stream.of(words)
                        .parallel()
                        .mapToInt(String::length)
                        .sum()
        );
    }
}
