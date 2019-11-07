package pl.janusz.buchalka.dsa.pt06;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class QueueTestImplCircular extends QueueTest {

    @Override
    protected Queue<String> getQueue() {

        return new CircularQueue<>();
    }

    @Test
    public void addFourElementsToSizeTwoQueue() {

        CircularQueue<String> queue = new CircularQueue<>(2);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.add(d);
        assertThat(queue.size(), is(4));
        assertThat(queue.remove(), is(a));
        assertThat(queue.size(), is(3));
        assertThat(queue.remove(), is(b));
        assertThat(queue.size(), is(2));
        assertThat(queue.remove(), is(c));
        assertThat(queue.size(), is(1));
        assertThat(queue.remove(), is(d));
        assertThat(queue.size(), is(0));
    }

    @Test
    public void circleThrouhTwoElementsQueue() {

        CircularQueue<String> queue = new CircularQueue<>(2);

        assertThat(queue.size(), is(0));
        queue.add(a);
        assertThat(queue.size(), is(1));
        queue.add(b);
        assertThat(queue.size(), is(2));

        assertThat(queue.remove(), is(a));
        assertThat(queue.size(), is(1));
        queue.add(c);
        assertThat(queue.size(), is(2));
        assertThat(queue.remove(), is(b));
        assertThat(queue.size(), is(1));
        queue.add(d);
        assertThat(queue.size(), is(2));
        assertThat(queue.remove(), is(c));
        assertThat(queue.size(), is(1));
        assertThat(queue.remove(), is(d));
        assertThat(queue.size(), is(0));
    }
}
