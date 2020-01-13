package pl.janusz.shewchuk.lec02;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 06/01/2020. Project; bielmarcus
 */
public class StrConcTest {

    @Test
    public void concatStrings() {

        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        String s4 = "x";
        String s5 = "y";
        String s6 = "z";

        String concat = s1.concat(s2).concat(s3).concat(s4).concat(s5).concat(s6);

        String expected = "abcxyz";
        assertThat(concat,is(equalTo(expected)));
    }

    @Test
    public void equalEmptyStr() {

        String s1 = new String();
        String s2 = "";

        assertThat(s1,is(equalTo(s2)));

    }
}