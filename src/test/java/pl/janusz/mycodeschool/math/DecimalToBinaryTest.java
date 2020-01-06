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
public class DecimalToBinaryTest {

    @Parameterized.Parameter(value = 0)
    public int number;
    @Parameterized.Parameter(value = 1)
    public String binary;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {0, "0"},
                {1, "1"},
                {2, "10"},
                {3, "11"},
                {4, "100"},
                {5, "101"},
                {6, "110"},
                {7, "111"},
                {8, "1000"},
                {9, "1001"},
                {10, "1010"},
                {10, "1010"},
                {11, "1011"},
                {12, "1100"},
                {13, "1101"},
                {14, "1110"},
                {15, "1111"},
                {16, "10000"},
                {17, "10001"},
                {18, "10010"},
                {19, "10011"},
                {20, "10100"}
        });
    }

    @Test
    public void sholdConvertToBinary() {

        String convert = DecimalToBinary.convert(number);
        String format = String.format("%d should be %s but was %s", number, binary, convert);
        assertThat(format, convert, is(equalTo(binary)));
    }
}