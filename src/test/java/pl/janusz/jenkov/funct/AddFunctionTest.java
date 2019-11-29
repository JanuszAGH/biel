package pl.janusz.jenkov.funct;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 28/11/2019. Project; bielmarcus
 */
public class AddFunctionTest {

    @Test
    public void adder() {

        BiFunction<Integer, Integer, Integer> adder = new BiFunction<Integer, Integer, Integer>() {

            @Override
            public Integer apply(Integer a, Integer b) {

                return a + b;
            }
        };

        Integer result = adder.apply(3, 4);
        assertThat(result, is(7));
    }
}