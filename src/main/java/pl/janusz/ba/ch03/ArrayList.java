package pl.janusz.ba.ch03;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public class ArrayList<E> implements List<E> {

    private static final int INITIAL_CAPACITY = 16;
    private java.lang.Object[] array;
    private int size;

    public ArrayList() {

        clear();
    }

    public ArrayList(int initialCapacity) {

        array = new Object[initialCapacity];
    }

    @Override
    public void add(int index, E value) throws IndexOutOfBoundsException {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        assureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    private void checkIndex(int index) {

        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(E value) {

        assureCapacity();
        array[size] = value;
        size++;
    }

    private void assureCapacity() {

        if (array.length < size + 1) {
            final Object[] temp = new Object[array.length * 2];
            System.arraycopy(array, 0, temp, 0, array.length);

            array = (E[]) temp;
        }
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {

        checkIndex(index);

        final E element = (E) array[index];

        System.arraycopy(array, index + 1, array, index, size() - index);
        size--;

        return element;
    }

    @Override
    public boolean remove(Object o) {

        int idx = findIdxBValue(o);

        if (idx > -1) {
            remove(idx);
        }

        return idx > -1;
    }

    private int findIdxBValue(Object o) {

        int idx = 0;
        while (idx < array.length) {
            if (o.equals(array[idx])) {
                return idx;
            }
            idx++;
        }

        return -1;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {

        checkIndex(index);

        return array[index];
    }

    @Override
    public Object set(int index, E value) throws IndexOutOfBoundsException {

        checkIndex(index);

        final Object o = array[index];
        array[index] = value;

        return o;
    }

    @Override
    public void clear() {

        array = new Object[INITIAL_CAPACITY];
        size = 0;
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
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public int indexOf(Object o) {

        return findIdxBValue(o);
    }

    @Override
    public Iterator<E> iterator() {

        return new ArrayListIterator<>();
    }

    private class ArrayListIterator<E> implements Iterator<E> {

        private int idx = 0;

        @Override
        public boolean hasNext() {

            return idx < size();
        }

        @Override
        public E next() {

            return (E) get(idx++);
        }

        @Override
        public void remove() {

            ArrayList.this.remove(idx - 1);
            idx--;
        }
    }
}
