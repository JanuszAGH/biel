package pl.janusz.buchalka.dsa.pt05;

import java.util.EmptyStackException;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class ArrayStack<E> implements Stack<E> {

    private static final int INITIAL_SIZE = 16;
    private int size;
    private int cursor;
    private Object[] array;

    public ArrayStack() {

        clear();
    }

    @Override
    public void push(E element) {

        assumeSpace();

        array[cursor++] = element;
        size++;
    }

    private void assumeSpace() {

        if (size == array.length) {
            final Object[] temp = new Object[array.length * 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    @Override
    public E pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        final E e = (E) array[--cursor];
        size--;
        array[cursor] = null;

        return e;
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (E) array[cursor - 1];
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public void clear() {

        array = new Object[INITIAL_SIZE];
        size = 0;
        cursor = 0;
    }
}
