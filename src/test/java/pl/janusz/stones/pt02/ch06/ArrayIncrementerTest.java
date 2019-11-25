package pl.janusz.stones.pt02.ch06;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class ArrayIncrementerTest {

    @Test
    public void incByTen() {

        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayIncrementer.increment(array, 10);
        assertThat(array, is(arrayContaining(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)));
    }
}