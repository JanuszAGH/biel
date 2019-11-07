package pl.janusz.buchalka.dsa.pt10;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 07/11/2019. Project; bielmarcus
 */
public abstract class HeapTest {

    protected Heap<Integer> heap;
    private List<Integer> numbers;
    private List<Integer> sortedReverse;

    @Before
    public void setUp() throws Exception {

        heap = getHeap();
        numbers = new ArrayList<>();
        sortedReverse = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            final int anInt = ThreadLocalRandom.current().nextInt(50);
            numbers.add(anInt);
            sortedReverse.add(anInt);
        }

        assertThat(sortedReverse, contains(numbers.toArray(new Integer[0])));
        Collections.sort(sortedReverse);
        Collections.reverse(sortedReverse);
    }

    protected abstract Heap<Integer> getHeap();

    @Test
    public void emptyAtTheBeginning() {

        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void insertOneElement() {

        heap.insert(1);
        assertThat(heap.isEmpty(), is(false));
    }

    @Test
    public void deleteFromEmptyHeapThrowsException() {

        try {
            heap.delete();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void insertTwoElementsAscending() {

        heap.insert(1);
        heap.insert(2);
        assertThat(heap.isEmpty(), is(false));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void insertTwoElementsDescending() {

        heap.insert(2);
        heap.insert(1);
        assertThat(heap.isEmpty(), is(false));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void insertThreeElementsAscending() {

        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        assertThat(heap.isEmpty(), is(false));
        assertThat(heap.delete(), is(3));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void insertThreeElementsDescending() {

        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        assertThat(heap.isEmpty(), is(false));
        assertThat(heap.delete(), is(3));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void insertThreeElementsAscendingEndMid() {

        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        assertThat(heap.isEmpty(), is(false));
        assertThat(heap.delete(), is(3));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void insertThreeElementsDescendingEndMid() {

        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        assertThat(heap.isEmpty(), is(false));
        assertThat(heap.delete(), is(3));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void fourInsertedRetrieved() {

        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        heap.insert(8);

        assertThat(heap.delete(), is(8));
        assertThat(heap.delete(), is(4));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
    }

    @Test
    public void tenInsertedRetrieved() {

        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        heap.insert(8);
        heap.insert(2);
        heap.insert(8);

        assertThat(heap.delete(), is(8));
        assertThat(heap.delete(), is(8));
        assertThat(heap.delete(), is(8));
        assertThat(heap.delete(), is(4));
        assertThat(heap.delete(), is(4));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.delete(), is(1));
    }

    @Test
    public void sevenSortedInv() {

        heap.insert(8);
        heap.insert(7);
        heap.insert(7);
        heap.insert(6);
        heap.insert(6);
        heap.insert(6);
        heap.insert(6);

        assertThat(heap.delete(), is(8));
        assertThat(heap.delete(), is(7));
        assertThat(heap.delete(), is(7));
        assertThat(heap.delete(), is(6));
        assertThat(heap.delete(), is(6));
        assertThat(heap.delete(), is(6));
        assertThat(heap.delete(), is(6));
    }

    @Test
    public void fiveElementsInsertedRetrieved() {

        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
//        heap.insert(4);
//        heap.insert(2);
//        heap.insert(8);
//        heap.insert(2);
//        heap.insert(8);

        assertThat(heap.delete(), is(8));
//        assertThat(heap.delete(), is(8));
//        assertThat(heap.delete(), is(8));
        assertThat(heap.delete(), is(4));
//        assertThat(heap.delete(), is(4));
//        assertThat(heap.delete(), is(4));
//        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(2));
//        assertThat(heap.delete(), is(2));
//        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.delete(), is(1));
    }

    @Test
    public void sixElementsInsertedRetrieved() {

        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        heap.insert(4);
//        heap.insert(4);
//        heap.insert(2);
//        heap.insert(8);
//        heap.insert(2);
//        heap.insert(8);

        assertThat(heap.delete(), is(8));
//        assertThat(heap.delete(), is(8));
//        assertThat(heap.delete(), is(8));
        assertThat(heap.delete(), is(4));
        assertThat(heap.delete(), is(4));
//        assertThat(heap.delete(), is(4));
//        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(2));
//        assertThat(heap.delete(), is(2));
//        assertThat(heap.delete(), is(2));
        assertThat(heap.delete(), is(1));
        assertThat(heap.delete(), is(1));
    }

    @Test
    public void serveAHundredEntries() {

        numbers.forEach(heap::insert);
        List<Integer> result = new ArrayList<>();

        while (!heap.isEmpty()) {
            result.add(heap.delete());
        }

        assertThat(result, contains(sortedReverse.toArray(new Integer[0])));
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    public void emptyHeapExceptionWhenPeek() {

        heap.insert(1);
        try {
            heap.peek();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void heapAndPriorityQueue() {

        final PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < 1000; i++) {
            final Integer anInt = Integer.valueOf(ThreadLocalRandom.current().nextInt(100));
            heap.insert(anInt);
            queue.add(anInt);
        }

        while (!heap.isEmpty()) {
            assertThat(heap.delete(), is(queue.remove()));
        }

        assertThat(heap.isEmpty(), is(true));
        assertThat(queue.isEmpty(), is(true));
    }
}