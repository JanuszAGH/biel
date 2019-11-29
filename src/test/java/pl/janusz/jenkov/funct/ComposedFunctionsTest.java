package pl.janusz.jenkov.funct;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.function.Function;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 28/11/2019. Project; bielmarcus
 */
public class ComposedFunctionsTest {

    private Function<Integer, Integer> doubleValue;
    private Function<Integer, Integer> powerTwoValue;
    private int x;
    private int expected;
    private Function<Integer, Integer> doublePower;

    @Before
    public void setUp() throws Exception {

        doubleValue = a -> 2 * a;
        powerTwoValue = a -> a * a;
        x = 2;
        expected = 8;
    }

    @Test
    public void compose() {

        doublePower = doubleValue.compose(powerTwoValue);
        Integer apply = doublePower.apply(x);
        assertThat(apply, is(expected));
    }

    @Test
    public void andThen() {

        doublePower = powerTwoValue.andThen(doubleValue);
        Integer apply = doublePower.apply(x);
        assertThat(apply, is(expected));
    }
}