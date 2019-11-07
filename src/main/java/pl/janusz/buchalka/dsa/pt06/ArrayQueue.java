package pl.janusz.buchalka.dsa.pt06;

import java.util.NoSuchElementException;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int INITIAL_CAPACITY = 2;
    private Object[] array;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue() {

        clear();
    }

    @Override
    public void add(E element) {

        assureCapacity();
        array[tail++] = element;
        size++;
    }

    private void assureCapacity() {

        if (array.length == size() || array.length == tail) {
            final Object[] temp = new Object[array.length * 2];
            System.arraycopy(array, head, temp, 0, tail - head);
            tail = tail - head;
            head = 0;
            array = temp;
        }
    }

    @Override
    public E remove() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        size--;
        final E e = (E) array[head++];
        array[head - 1] = null;

        return e;
    }

    @Override
    public E peek() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        return (E) array[head];
    }

    @Override
    public boolean isEmpty() {

        return size() == 0;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void clear() {

        array = new Object[INITIAL_CAPACITY];
        head = 0;
        tail = 0;
        size = 0;
    }
}
