package pl.janusz.buchalka.dsa.pt05;

import java.util.EmptyStackException;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class LinkedListStack<E> implements Stack<E> {

    private int size;
    private Node<E> head;

    public LinkedListStack() {

        clear();
    }

    @Override
    public void push(E element) {

        final Node<E> node = new Node(element);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public E pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        final Node<E> node = head;

        E value = node.element;
        head = node.next;
        size--;

        return value;
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return head.element;
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

        head = null;
        size = 0;
    }

    private class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element) {

            this.element = element;
        }
    }
}
