package pl.janusz.mycodeschool.binsearch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 13/12/2019. Project; bielmarcus
 */
public abstract class BinSearchTest {

    private Integer[] array;
    private BinSearch binSearch;

    @Before
    public void setUp() throws Exception {

        array = new Integer[]{2, 6, 13, 21, 36, 47, 63, 81, 97};
        binSearch = getBinSearch();
    }

    protected abstract BinSearch getBinSearch();

    @Test
    public void ShouldFind81() {

        int key = 81;
        int search = binSearch.search(array, key);
        assertThat(array[search], is(key));
    }

    @Test
    public void shouldNotFind25() {

        int key = 25;
        int search = binSearch.search(array, key);
        assertThat(search, is(-1));
    }

    @Test
    public void ShouldFind21() {

        int key = 81;
        int search = binSearch.search(array, key);
        assertThat(array[search], is(key));
    }

    @Test
    public void shouldNotFind82() {

        int key = 82;
        int search = binSearch.search(array, key);
        assertThat(search, is(-1));
    }
}