package pl.janusz.stones.pt02.ch04.benchamark;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class SumTest {

    private static final int SIZE = 1_000_000;
    private ForkJoinPool forkJoinPool;
    private Integer[] array;

    @Before
    public void setUp() throws Exception {

        forkJoinPool = ForkJoinPool.commonPool();
        array = new Integer[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    @After
    public void tearDown() throws Exception {

        forkJoinPool.shutdown();
    }

    @Test
    public void calculateSumAverageThreshold() {

        final Long invoke = forkJoinPool.invoke(new Sum(array, 0, SIZE, 1_000));
        assertThat(invoke, is(500_000_500_000L));
    }

    @Test
    public void calculateSumSmallThreshold() {

        final Long invoke = forkJoinPool.invoke(new Sum(array, 0, SIZE, 1_000));
        assertThat(invoke, is(500_000_500_000L));
    }

    @Test
    public void calculateSumBigThreshold() {

        final Long invoke = forkJoinPool.invoke(new Sum(array, 0, SIZE, 100_000));
        assertThat(invoke, is(500_000_500_000L));
    }
}