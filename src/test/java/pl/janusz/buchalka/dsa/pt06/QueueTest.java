package pl.janusz.buchalka.dsa.pt06;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public abstract class QueueTest {

    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected Queue<String> queue;

    @Before
    public void setUp() throws Exception {

        queue = getQueue();
        a = "A";
        b = "B";
        c = "C";
        d = "D";
        e = "E";
    }

    protected abstract Queue<String> getQueue();

    @Test
    public void shouldBeEmptyAtTheBeginning() {

        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.size(), is(0));
    }

    @Test
    public void clean() {

        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.size(), is(0));

        queue.add(a);

        assertThat(queue.isEmpty(), is(false));
        assertThat(queue.size(), is(1));

        queue.clear();
        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.size(), is(0));
    }

    @Test
    public void addOneElementToEmptyQueue() {

        queue.add(a);
        assertThat(queue.size(), is(1));
        final String remove = queue.remove();
        assertThat(queue.size(), is(0));
        assertThat(remove, is(a));
    }

    @Test
    public void addOneElementRemoveOneAddOneRemoveOneAndAgain() {

        queue.add(a);
        assertThat(queue.size(), is(1));
        assertThat(queue.remove(), is(a));
        assertThat(queue.size(), is(0));
        queue.add(b);
        assertThat(queue.size(), is(1));
        assertThat(queue.remove(), is(b));
        assertThat(queue.size(), is(0));
        queue.add(c);
        assertThat(queue.size(), is(1));
        assertThat(queue.remove(), is(c));
        assertThat(queue.size(), is(0));
    }

    @Test
    public void peekOneElementQueue() {

        queue.add(a);
        assertThat(queue.peek(), is(a));
        assertThat(queue.size(), is(1));
    }

    @Test
    public void peekThreeElementQueue() {

        queue.add(a);
        queue.add(b);
        queue.add(c);

        assertThat(queue.peek(), is(a));
        assertThat(queue.size(), is(3));
        assertThat(queue.remove(), is(a));

        assertThat(queue.peek(), is(b));
        assertThat(queue.size(), is(2));
        assertThat(queue.remove(), is(b));

        assertThat(queue.peek(), is(c));
        assertThat(queue.size(), is(1));
        assertThat(queue.remove(), is(c));
    }

    @Test
    public void emptyQueueWhenPeekThenException() {

        try {
            queue.peek();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void emptyQueueWhenRemoveThenException() {

        try {
            queue.remove();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(NoSuchElementException.class));
        }
    }

    @Test
    public void addTwentyElements() {

        int size = 20;
        final String s = "Element ";
        for (int i = 0; i < size; i++) {
            queue.add(s + (i + 1));
        }
        assertThat(queue.size(), is(size));

        for (int i = 0; i < size; i++) {
            assertThat(queue.remove(), is(s + (i + 1)));
        }

        assertThat(queue.size(), is(0));
    }

    @Test
    public void add5ElementsAndRemove4ElementsAThousandTimes() {

        for (int i = 0; i < 1000; i++) {
            queue.add(a);
            queue.add(b);
            queue.add(c);
            queue.add(d);
            queue.add(e);
            assertThat(queue.remove(), is(a));
            assertThat(queue.size(), is(4));
            assertThat(queue.remove(), is(b));
            assertThat(queue.size(), is(3));
            assertThat(queue.remove(), is(c));
            assertThat(queue.size(), is(2));
            assertThat(queue.remove(), is(d));
            assertThat(queue.size(), is(1));
            assertThat(queue.remove(), is(e));
            assertThat(queue.size(), is(0));
        }

        assertThat(queue.size(), is(0));
    }

    @Test
    public void addRemoveFiveTimes() {

        queue.add(a);
        queue.add(b);
        assertThat(queue.remove(), is(a));
        queue.add(c);
        assertThat(queue.remove(), is(b));
        queue.add(d);
        assertThat(queue.remove(), is(c));
        queue.add(e);
        assertThat(queue.remove(), is(d));
        assertThat(queue.size(),is(1));
        assertThat(queue.remove(),is(e));
        assertThat(queue.size(),is(0));
    }
}