package pl.janusz.zooce;

import org.hamcrest.collection.IsArrayContaining;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public abstract class SortersTest {

    private Integer[] unsorted;
    private Integer[] sorted;
    private Sorters sorter;

    @Before
    public void setUp() throws Exception {

        unsorted = new Integer[]{1, 3, 5, 2, 4, 6, 10, 8, 9, 7};
        sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sorter = createSorter();
    }

    private Sorters createSorter() {

        return obtainSorter();
    }

    protected abstract Sorters obtainSorter();

    @Test
    public void sortOneElement() {

        Integer[] a = {1};
        Integer[] sorted = {1};
        sorter.sort(a);
        assertThat(a, arrayContaining(1));
    }

    @Test
    public void sortTwoElementSorted() {

        Integer[] a = {1, 2};
        Integer[] sorted = {1, 2};
        sorter.sort(a);
        assertThat(a, arrayContaining(sorted));
    }

    @Test
    public void sortTwoElementUnsorted() {

        Integer[] a = {2, 1};
        Integer[] sorted = {1, 2};
        sorter.sort(a);
        assertThat(a, arrayContaining(sorted));
    }

    @Test
    public void sortThreeElementUnsorted() {

        Integer[] a = {3, 2, 1};
        Integer[] sorted = {1, 2, 3};
        sorter.sort(a);
        assertThat(a, arrayContaining(sorted));
    }

    @Test
    public void sortThreeElementSorted() {

        Integer[] a = {1, 2, 3};
        Integer[] sorted = {1, 2, 3};
        sorter.sort(a);
        assertThat(a, arrayContaining(sorted));
    }

    @Test
    public void sortTenEmenets() {

        sorter.sort(unsorted);
        assertThat(unsorted, arrayContaining(sorted));
    }
}