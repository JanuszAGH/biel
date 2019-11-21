package pl.janusz.stones.pt01.ch01;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class RemoveDuplicatesTest {

    @Test
    public void oneWord() {

        final String alice = "Alice";
        final String result = RemoveDuplicates.removeDuplicatedWords(alice);
        assertThat(result, is(equalTo(alice)));
    }

    @Test
    public void twoWords() {

        final String alice = "Alice Cat";
        final String result = RemoveDuplicates.removeDuplicatedWords(alice);
        assertThat(result, is(equalTo(alice)));
    }

    @Test
    public void threeWords() {

        final String alice = "Alice in Wonderland";
        final String result = RemoveDuplicates.removeDuplicatedWords(alice);
        assertThat(result, is(equalTo(alice)));
    }

    @Test
    public void threeDuplicatedWords() {

        final String alice = "Alice in Wonderland Alice in Wonderland";
        final String result = RemoveDuplicates.removeDuplicatedWords(alice);
        final String expected = "Alice in Wonderland";
        assertThat(result, is(equalTo(expected)));
    }

    @Test
    public void manyDuplicatedWords() {

        final String alice = "Alice in Alice in 123 Alice XYZ Wonderland Alice in 123 Alice XYZ XYZ 123 XYZ 123 in Wonderland Wonderland Wonderland Alice in Wonderland";
        final String result = RemoveDuplicates.removeDuplicatedWords(alice);
        final String expected = "Alice in 123 XYZ Wonderland";
        assertThat(result, is(equalTo(expected)));
    }
}