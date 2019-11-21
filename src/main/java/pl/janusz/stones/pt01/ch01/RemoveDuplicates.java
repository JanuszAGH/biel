package pl.janusz.stones.pt01.ch01;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public final class RemoveDuplicates {

    public static String removeDuplicates(String text) {

        final String[] words = text.split(" ");

        Set<String> set = new LinkedHashSet<>(Arrays.asList(words));

        final StringJoiner stringJoiner = new StringJoiner(" ");
        for (String s : set) {
            stringJoiner.add(s);
        }

        return stringJoiner.toString();
    }

    public static String removeDuplicatedWords(String text) {

        return String.join(" ",
                Stream.of(text.split(" "))
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
    }
}
