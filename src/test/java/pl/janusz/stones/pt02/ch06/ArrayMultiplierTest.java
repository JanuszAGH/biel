package pl.janusz.stones.pt02.ch06;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class ArrayMultiplierTest {

    private Integer[][] a;
    private Integer[][] b;
    private Integer[][] expected;

    @Before
    public void setUp() throws Exception {

        a = new Integer[][]{
                {1, -4, 6},
                {7, 4, 3}
        };

        b = new Integer[][]{
                {8, 9, -3},
                {5, 2, -1},
                {3, 6, 4}
        };

        expected = new Integer[][]{
                {6, 37, 25},
                {85, 89, -13}
        };
    }

    @Test
    public void multiply() {

        final Integer[][] product = ArrayMultiplier.multiply(a, b);
        for (int i = 0; i < expected.length; i++) {
            assertThat(product[i], is(arrayContaining(expected[i])));
        }

        System.out.println(Arrays.deepToString(product));
    }

    @Test
    public void multiplyParallelly() {

        final Integer[][] product = ArrayMultiplier.multiplyParallelly(a, b);
        for (int i = 0; i < expected.length; i++) {
            assertThat(product[i], is(arrayContaining(expected[i])));
        }

        System.out.println(Arrays.deepToString(product));
    }
}