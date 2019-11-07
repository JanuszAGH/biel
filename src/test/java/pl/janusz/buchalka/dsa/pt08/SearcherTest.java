package pl.janusz.buchalka.dsa.pt08;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public abstract class SearcherTest {

    protected Searcher searcher;
    protected Integer[] array;

    @Before
    public void setUp() throws Exception {

        searcher = getSearcher();
        array = new Integer[]{20, 35, -15, 7, 55, 1, -22};
    }

    protected abstract Searcher getSearcher();

    @Test
    public void findInOneelementArray() {

        final int idx = searcher.search(new Integer[]{7}, 7);
        assertThat(idx, is(0));
    }

    @Test
    public void findMinusOneOneelementArray() {

        final int idx = searcher.search(new Integer[]{1}, 2);
        assertThat(idx, is(-1));
    }

    @Test
    public void findMid() {

        final int idx = searcher.search(new Integer[]{1, 2, 3}, 2);
        assertThat(idx, is(1));
    }

    @Test
    public void findOnLeft() {

        final int idx = searcher.search(new Integer[]{1, 2, 3}, 1);
        assertThat(idx, is(0));
    }

    @Test
    public void findOnRight() {

        final int idx = searcher.search(new Integer[]{1, 2, 3}, 3);
        assertThat(idx, is(2));
    }

    @Test
    public void shouldFindFromBiggerArray() {

        final int key = -15;
        final int search = searcher.search(array, key);
        assertThat(array[search], is(key));
    }

    @Test
    public void shouldNotFindFromBiggerArray() {

        final int key = -13;
        final int search = searcher.search(array, key);
        assertThat(search, is(-1));
    }
}