package pl.janusz.ba.ch03;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {

        clear();
    }

    @Override
    public void add(int index, E value) throws IndexOutOfBoundsException {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeAtIdx = getNodeByIdx(index);
        final Node<E> node = new Node<>(value);
        node.next = nodeAtIdx.next;
        node.prev = nodeAtIdx;
        nodeAtIdx.next.prev = node;
        nodeAtIdx.next = node;
        size++;
    }

    private void checkIndex(int index) {

        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> getNodeByIdx(int index) {

        Node<E> slider = head;

        while (index > 0) {
            slider = slider.next;
            index--;
        }
        return slider;
    }

    @Override
    public void add(E value) {

        add(size(), value);
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {

        checkIndex(index);
        final Node<E> nodeByIdx = getNodeByIdx(index);
        E el = nodeByIdx.next.element;
        nodeByIdx.next = nodeByIdx.next.next;
        nodeByIdx.next.prev = nodeByIdx;
        size--;

        return el;
    }

    @Override
    public boolean remove(Object o) {

        int idx = findIndexByValue(o);

        if (idx > -1) {
            remove(idx);
        }

        return idx > -1;
    }

    private int findIndexByValue(Object o) {

        Node<E> slider = head;
        int idx = 0;
        while (idx < size && !o.equals(slider.next.element)) {
            idx++;
            slider = slider.next;
        }

        return idx < size() ? idx : -1;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {

        checkIndex(index);

        final Node<E> nodeByIdx = getNodeByIdx(index + 1);

        return nodeByIdx.element;
    }

    @Override
    public Object set(int index, E value) throws IndexOutOfBoundsException {

        checkIndex(index);

        final Node<E> nodeByIdx = getNodeByIdx(index + 1);
        final E element = nodeByIdx.element;
        nodeByIdx.element = value;

        return element;
    }

    @Override
    public void clear() {

        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;

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

        return findIndexByValue(o);
    }

    @Override
    public Iterator<E> iterator() {

        return new LinkedListIterator<>();
    }

    private class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element) {

            this.element = element;
        }
    }

    private class LinkedListIterator<E> implements Iterator<E> {

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

            LinkedList.this.remove(idx - 1);
            idx--;
        }
    }
}
