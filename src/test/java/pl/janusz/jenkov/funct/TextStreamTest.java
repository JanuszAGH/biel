package pl.janusz.jenkov.funct;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 28/11/2019. Project; bielmarcus
 */
public class TextStreamTest {

    @Test
    public void textLengths() {

        ArrayList<Integer> list = Stream.of("Alice", "in", "Wonderland")
                .map(String::length)
                .collect(Collectors.toCollection(ArrayList::new));

        assertThat(list, contains(5, 2, 10));
    }
}