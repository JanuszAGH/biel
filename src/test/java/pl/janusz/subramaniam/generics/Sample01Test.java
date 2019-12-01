package pl.janusz.subramaniam.generics;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class Sample01Test {

    private List<Integer> numbers;
    private Integer[] integers;

    private <T extends Comparable<? super T>> void copyListToList(List<T> src, List<T> dst) {

        dst.addAll(src);
    }

    private <T extends Number> Double sum(List<T> collection) {

        Double sum = 0.0;
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            sum += next.doubleValue();
        }

        return sum;
    }

    @Before
    public void setUp() throws Exception {

        integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        numbers = new ArrayList<>(Arrays.asList(integers));
    }

    @Test
    public void copyListsTest() {

        List<Integer> destination = new ArrayList<>();

        assertThat(destination, hasSize(0));

        copyListToList(numbers, destination);
        assertThat(destination, contains(integers));
    }

    @Test
    public void sumTest() {

        Double sum = sum(numbers);
        assertThat(sum, is(55.0));
    }
}