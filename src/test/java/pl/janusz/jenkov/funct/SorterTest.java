package pl.janusz.jenkov.funct;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 28/11/2019. Project; bielmarcus
 */
public class SorterTest {

    @Test
    public void shouldSort() {

        List<Integer> numbers = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

        Integer[] sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Comparator<Integer> integerComparator = (a, b) -> {return a - b;};
        Comparator<Integer> reversed = integerComparator.reversed();
        Collections.sort(numbers, reversed);
        Integer[] clone = sorted.clone();
        Arrays.sort(clone, reversed);
        assertThat(numbers, contains(clone));

        Collections.sort(numbers, integerComparator);
        assertThat(numbers, contains(sorted));
    }
}