package pl.janusz.buchalka.dsa.pt05;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.EmptyStackException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public abstract class StackTest {

    private Stack<String> stack;
    private String a;
    private String b;
    private String c;

    @Before
    public void setUp() throws Exception {

        stack = getStack();
        this.a = "a";
        this.b = "b";
        this.c = "c";
    }

    protected abstract Stack<String> getStack();

    @Test
    public void pushOneEement() {

        stack.push(a);
        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.size(), is(1));

        final String pop = stack.pop();
        assertThat(pop, is(equalTo(a)));

        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void shouldBeEmpty() {

        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void pushTwoElements() {

        assertThat(stack.size(), is(0));
        stack.push(a);
        assertThat(stack.size(), is(1));
        stack.push(b);
        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(b));
        assertThat(stack.size(), is(1));
        assertThat(stack.pop(), is(a));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void pushThreeElements() {

        assertThat(stack.size(), is(0));
        stack.push(a);
        assertThat(stack.size(), is(1));
        stack.push(b);
        assertThat(stack.size(), is(2));
        stack.push(c);
        assertThat(stack.size(), is(3));
        assertThat(stack.pop(), is(c));
        assertThat(stack.size(), is(2));
        assertThat(stack.pop(), is(b));
        assertThat(stack.size(), is(1));
        assertThat(stack.pop(), is(a));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void popFromEmptyStackThrowsException() {

        try {
            stack.pop();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(EmptyStackException.class));
        }
    }

    @Test
    public void peekFromEmptyStackThrowsException() {

        try {
            stack.peek();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(EmptyStackException.class));
        }
    }

    @Test
    public void peekFromOneElementStack() {

        stack.push(a);
        assertThat(stack.peek(), is(a));
        assertThat(stack.peek(), is(a));
        assertThat(stack.size(), is(1));
        assertThat(stack.pop(), is(a));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void peekFromThreeElementStack() {

        stack.push(a);
        assertThat(stack.peek(), is(a));
        assertThat(stack.peek(), is(a));
        assertThat(stack.size(), is(1));
        stack.push(b);
        assertThat(stack.peek(), is(b));
        assertThat(stack.peek(), is(b));
        assertThat(stack.size(), is(2));
        stack.push(c);
        assertThat(stack.peek(), is(c));
        assertThat(stack.peek(), is(c));
        assertThat(stack.size(), is(3));

        assertThat(stack.peek(), is(c));
        assertThat(stack.peek(), is(c));
        assertThat(stack.pop(), is(c));
        assertThat(stack.size(), is(2));

        assertThat(stack.peek(), is(b));
        assertThat(stack.peek(), is(b));
        assertThat(stack.pop(), is(b));
        assertThat(stack.size(), is(1));

        assertThat(stack.peek(), is(a));
        assertThat(stack.peek(), is(a));
        assertThat(stack.pop(), is(a));
        assertThat(stack.size(), is(0));
    }

    @Test
    public void shouldClearStack() {

        stack.push(a);
        stack.push(b);
        stack.push(c);
        assertThat(stack.size(), is(3));
        stack.clear();
        assertThat(stack.size(), is(0));
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void shouldPushMoreThan16Elements() {

        final int elements = 50;
        for (int i = 0; i < elements; i++) {
            final int no = i + 1;
            stack.push("Number " + no);
        }

        assertThat(stack.size(), is(elements));
        for (int i = elements; i > 0; i--) {
            assertThat(stack.pop(), is(equalTo("Number " + i)));
        }
        assertThat(stack.isEmpty(), is(true));
    }
}