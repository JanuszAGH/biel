package pl.janusz.buchalka.dsa.pt05.palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.Param;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class PalindromeParameterizedTest {

    @Parameterized.Parameter(0)
    public String word;
    @Parameterized.Parameter(1)
    public boolean isPalindrome;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {null, true},
                {"", true},
                {" aa", true},
                {" aa  ", true},
                {"aa  ", true},
                {" aa   ", true},
                {"A", true},
                {"a", true},
                {"aA", true},
                {"Aa", true},
                {"ABBA", true},
                {"I did, did I", true},
                {"Was it a car or a cat I saw", true},
                {"Don't nod", true},
                {"RaceCar", true},
                {"kayak", true},
                {"Akka", true},
                {"1221", true},
                {"Maya", false},
                {"123", false},
                {"abc", false}
        });
    }

    @Test
    public void test_PalindromeParameterized() throws Exception {

        final boolean palindrome = PalindromeChecker.isPalindrome(word);
        final String format = String.format("%s should be %s but was %s", word, isPalindrome, palindrome);
        assertThat(format, palindrome, is(isPalindrome));
    }
}