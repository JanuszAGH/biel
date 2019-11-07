package pl.janusz.buchalka.dsa.pt05.palindrome;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class PalindromeCheckerTest {

    @Test
    public void emptyStringIsPalindrome() {

        assertThat(PalindromeChecker.isPalindrome(""), is(true));
    }

    @Test
    public void shouldNotBePalindrome12() {

        final boolean palindrome = PalindromeChecker.isPalindrome("12");
        assertThat(palindrome, is(false));
    }

    @Test
    public void shouldNotBePalindrome123() {

        final boolean palindrome = PalindromeChecker.isPalindrome("12");
        assertThat(palindrome, is(false));
    }

    @Test
    public void shouldBePalindrome121() {

        assertThat(PalindromeChecker.isPalindrome("121"), is(true));
    }

    @Test
    public void shouldBePalindrome1221() {

        assertThat(PalindromeChecker.isPalindrome("1221"), is(true));
    }

    @Test
    public void shouldBePalindrome12_21() {

        final boolean palindrome = PalindromeChecker.isPalindrome("1 1     2  21 1");
        assertThat(palindrome, is(true));
    }

    @Test
    public void shouldBeDontnod() {

        final boolean palindrome = PalindromeChecker.isPalindrome("Don't nod");
        assertThat(palindrome, is(true));
    }

    @Test
    public void kayakIsPalindrome() {

        final boolean kayak = PalindromeChecker.isPalindrome("kayak");
        assertThat(kayak, is(true));
    }

    @Test
    public void akkaIsPalindrome() {

        final boolean akka = PalindromeChecker.isPalindrome("Akka");
        assertThat(akka, is(true));
    }
    @Test
    public void String1221IsPalindrome() {

        final boolean result = PalindromeChecker.isPalindrome("1221");
        assertThat(result, is(true));
    }
}