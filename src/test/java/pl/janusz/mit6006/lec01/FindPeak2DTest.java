package pl.janusz.mit6006.lec01;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 06/01/2020. Project; bielmarcus
 */
public class FindPeak2DTest {

    @Test
    public void sholdFindPeakBasicCase() {
        Integer arr[] = {1, 3, 20, 4, 1, 0};
        int peak = FindPeak2D.findPeak(arr);
        assertThat(peak,is(2));
    }
}