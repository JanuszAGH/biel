package pl.janusz.buchalka.dsa.pt06;

import java.util.NoSuchElementException;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class CircularQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 2;

    private int capacity;
    private Object[] array;
    private int head;
    private int tail;
    private int size;

    public CircularQueue() {

        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int size) {

        this.capacity = size;
        clear();
    }

    @Override
    public void add(E element) {

        assureCapacity();

        array[tail] = element;
        size++;
        tail = (tail + 1) % capacity;
    }

    private void assureCapacity() {

        if (size() == array.length) {
            Object[] temp = new Object[array.length * 2];

            if (tail > head) {
                System.arraycopy(array, head, temp, 0, size());
            } else {
                System.arraycopy(array, head, temp, 0, array.length - head);
                System.arraycopy(array, 0, temp, array.length - head, tail);
            }

            head = 0;
            tail = size();
            array = temp;
            capacity *= 2;
        }
    }

    @Override
    public E remove() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        final E e = (E) array[head];
        array[head] = null;
        head = (head + 1) % capacity;
        size--;

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
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size() == 0;
    }

    @Override
    public void clear() {

        array = new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }
}
