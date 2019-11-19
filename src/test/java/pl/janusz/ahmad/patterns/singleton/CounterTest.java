package pl.janusz.ahmad.patterns.singleton;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class CounterTest {

    @Test
    public void incToSix() {

        final Counter c1 = Counter.getInstance();
        c1.inc();
        c1.inc();
        c1.inc();
        final Counter c2 = Counter.getInstance();
        c2.inc();
        c2.inc();
        c2.inc();
        assertThat(c1.getCount(), is(6));
        assertThat(c2.getCount(), is(6));
    }
}