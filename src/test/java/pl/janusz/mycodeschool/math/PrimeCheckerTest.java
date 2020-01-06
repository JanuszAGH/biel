package pl.janusz.mycodeschool.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
@RunWith(Parameterized.class)
public class PrimeCheckerTest {

    @Parameterized.Parameter(value = 0)
    public int n;
    @Parameterized.Parameter(value = 1)
    public boolean prime;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {1, false},
                {2, true},
                {3, true},
                {4, false},
                {5, true},
                {6, false},
                {7, true},
                {8, false},
                {9, false},
                {10, false},
                {11, true},
                {12, false},
                {13, true},
                {14, false},
                {15, false},
                {16, false},
                {17, true},
                {18, false},
                {19, true},
                {20, false},
                {21, false}
        });
    }

    @Test
    public void shuldCheckIfIsPrime() {

        boolean check = PrimeChecker.check(n);
        String format = String.format("%d should be %s bu was %s", n, prime, check);
        assertThat(format, check, is(prime));
    }
}