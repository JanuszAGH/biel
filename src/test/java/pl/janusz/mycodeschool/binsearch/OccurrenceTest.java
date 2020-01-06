package pl.janusz.mycodeschool.binsearch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 13/12/2019. Project; bielmarcus
 */
public class OccurrenceTest {

    private Integer[] array;
    private Occurrence occurrence;

    @Before
    public void setUp() throws Exception {

        array = new Integer[]{1, 1, 3, 3, 5, 5, 5, 5, 7, 9, 9, 11};
        occurrence = new Occurrence();
    }

    @Test
    public void forSevenIsOne() {

        int occurrence = this.occurrence.occurrence(array, 7);
        assertThat(occurrence, is(1));
    }

    @Test
    public void forOneIsTwo() {

        int occurrence = this.occurrence.occurrence(array, 1);
        assertThat(occurrence, is(2));
    }
}