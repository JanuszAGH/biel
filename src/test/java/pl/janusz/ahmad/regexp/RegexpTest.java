package pl.janusz.ahmad.regexp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 15/11/2019. Project; bielmarcus
 */
public class RegexpTest {

    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private String s5;

    @Before
    public void setUp() throws Exception {

        s1 = "";
        s2 = " ";
        s3 = "a";
        s4 = "abc";
        s5 = "Alice in Wonderland";
    }

    @Test
    public void matchAnyString() {

        final String regexp = ".*";

        assertTrue(s1.matches(regexp));
        assertTrue(s2.matches(".*"));
        assertTrue(s3.matches(".*"));
        assertTrue(s4.matches(".*"));
        assertTrue(s5.matches(".*"));
    }

    @Test
    public void matchOneCharacter() {

        final String regexp = ".";
        assertTrue(" ".matches(regexp));
    }
}