package pl.janusz.langer.pt01;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class JoinedWords {

    public static void main(String[] args) {

        String[] words = new String[]{
                "Alice", "in", "Wonderland", "the", "Cat", "Alice", "in", "Wonderland", "the", "Cat"};

        System.out.println(Stream.of(words)
                .collect(Collectors.joining()));
        System.out.println(Stream.of(words)
                .reduce("", (a, e) -> a + e));
    }
}
