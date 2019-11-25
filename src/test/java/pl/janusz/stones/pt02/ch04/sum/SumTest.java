package pl.janusz.stones.pt02.ch04.sum;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class SumTest {

    @Test
    public void OneToTen() {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        final Sum sumTask1 = new Sum(array, 0, array.length);
        final Sum sumTask2 = new Sum(array, 0, array.length);
        final Long invoke1 = forkJoinPool.invoke(sumTask1);
        assertThat(invoke1, is(55L));

        final Long invoke2 = forkJoinPool.invoke(sumTask2);
        assertThat(invoke2, is(55L));

        
    }
}