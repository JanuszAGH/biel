package pl.janusz.jenkov.funct;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 28/11/2019. Project; bielmarcus
 */
public class AZPredicatesTest {

    @Test
    public void name() {

        Predicate<String> startsWithA = text -> text.startsWith("A");
        Predicate<String> endsWithZ = text -> text.endsWith("Z");
        Predicate<String> both = startsWithA.and(endsWithZ);
        String s = "ABC XYZ";

        assertThat(both.test(s), is(true));
        assertThat(startsWithA.test("ABC"), is(true));
        assertThat(endsWithZ.test("XYZ"), is(true));
        assertThat(startsWithA.test("abc"), is(false));
    }
}