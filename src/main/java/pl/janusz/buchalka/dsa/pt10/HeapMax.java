package pl.janusz.buchalka.dsa.pt10;

import java.util.NoSuchElementException;

/**
 * Created by Janusz Kacki on 06/11/2019. Project; bielmarcus
 */
public class HeapMax<E extends Comparable<? super E>> implements Heap<E> {

    private static final int INITIAL_CAPACITY = 1000;
    private E[] array;
    private int size;

    public HeapMax(int initialSize) {

        array = (E[]) new Comparable[initialSize];
        size = 0;
    }

    public HeapMax() {

        this(INITIAL_CAPACITY);
    }

    @Override
    public void insert(E element) {

        assureCapacity();
        array[size] = element;

        percolateUp(size);

        size++;
    }

    private void percolateUp(int position) {

        E temp = null;
        int parent;
        parent = getParent(position);
        while (position > 0
                && array[position].compareTo(array[parent]) > 0) {
            temp = array[parent];
            array[parent] = array[position];
            array[position] = temp;
            position = parent;
            parent = getParent(position);
        }
    }

    private int getParent(int position) {

        return (position - 1) / 2;
    }

    private int getLeftChild(int position) {

        return 2 * position + 1;
    }

    private int getRightChild(int position) {

        return 2 * position + 2;
    }

    private void assureCapacity() {

        if (size == array.length) {
            final E[] temp = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    @Override
    public E delete() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = array[0];
        size--;
        array[0] = array[size];
        array[size] = null;

        if (size > 0) {
            percolateDown(0);
        }

        return result;
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return array[0];
    }

    private void percolateDown(int position) {

        int biggerIdx;
        E temp = null;

        biggerIdx = getBiggerChildIdx(position);

        while (array[biggerIdx].compareTo(array[position]) > 0) {
            temp = array[position];
            array[position] = array[biggerIdx];
            array[biggerIdx] = temp;
            position = biggerIdx;
            biggerIdx = getBiggerChildIdx(position);
        }
    }

    private int getBiggerChildIdx(int parent) {

        if (getLeftChild(parent) < size && getRightChild(parent) < size) {
            return
                    array[getLeftChild(parent)].compareTo(array[getRightChild(parent)]) < 0 ?
                            getRightChild(parent) : getLeftChild(parent);
        }

        if (getLeftChild(parent) < size) {
            return getLeftChild(parent);
        }

        return parent;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }
}
