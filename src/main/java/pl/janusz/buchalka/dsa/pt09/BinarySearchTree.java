package pl.janusz.buchalka.dsa.pt09;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BinarySearchTree<E extends Comparable<? super E>> implements BST<E> {

    private Node<E> root;

    @Override
    public void insert(E element) {

        root = ins(root, element);
    }

    private Node<E> ins(Node<E> node, E key) {

        final Node<E> newOne = new Node<>(key);

        if (node == null) {
            return newOne;
        }

        if (key.compareTo(node.element) == 0) {
            return node;
        }

        if (key.compareTo(node.element) < 0) {
            node.left = ins(node.left, key);
        } else {
            node.right = ins(node.right, key);
        }

        return node;
    }

    @Override
    public void delete(E element) {

        root = del(root, element);
    }

    private Node<E> del(Node<E> node, E key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.element) < 0) {
            node.left = del(node.left, key);

            return node;
        }

        if (key.compareTo(node.element) > 0) {
            node.right = del(node.right, key);

            return node;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        if (node.left != null && node.right != null) {

            final E min = maxInSubtree(node.left);
            node.element = min;
            node.left = del(node.left, min);

            return node;
        }

        if (node.left == null) {
            return node.right;
        } else {
            return node.left;
        }
    }

    private E maxInSubtree(Node<E> node) {

        Node<E> slider = node;
        while (slider.right != null) {
            slider = slider.right;
        }

        return slider.element;
    }

    @Override
    public boolean contains(E element) {

        if (root == null) {
            return false;
        }

        Node<E> slider = root;
        while (slider != null) {
            if (element.compareTo(slider.element) == 0) {
                return true;
            }

            if (element.compareTo(slider.element) < 0) {
                slider = slider.left;
            } else {
                slider = slider.right;
            }
        }

        return false;
    }

    @Override
    public E min() {

        if (root == null) {
            return null;
        }

        Node<E> slider = root;

        while (slider.left != null) {
            slider = slider.left;
        }

        return slider.element;
    }

    @Override
    public E max() {

        if (root == null) {
            return null;
        }

        Node<E> slider = root;
        while (slider.right != null) {
            slider = slider.right;
        }

        return slider.element;
    }

    @Override
    public Iterator<E> iterator() {

        return new InOrderIterator<E>();
    }

    @Override
    public boolean isBST() {

        return recCheckBST(root);
    }

    private boolean recCheckBST(Node<E> node) {

        if (node == null) {
            return true;
        }

        if (node.left != null && !(node.left.element.compareTo(node.element) < 0)) {
            return false;
        }
        if (node.right != null && !(node.element.compareTo(node.right.element) < 0)) {
            return false;
        }

        if (!recCheckBST(node.left)) {
            return false;
        }
        if (!recCheckBST(node.right)) {
            return false;
        }

        return true;
    }

    private class Node<E extends Comparable<? super E>> {

        private E element;
        private Node<E> left;
        private Node<E> right;

        public Node(E element) {

            this.element = element;
        }
    }

    private class InOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

        Deque<E> queue;

        public InOrderIterator() {

            queue = new LinkedList<>();
            traverseInOrder((Node<E>) root);
        }

        private void traverseInOrder(Node<E> node) {

            if (node == null) {
                return;
            }

            traverseInOrder(node.left);
            queue.add(node.element);
            traverseInOrder(node.right);
        }

        @Override
        public boolean hasNext() {

            return !queue.isEmpty();
        }

        @Override
        public E next() {

            return queue.remove();
        }
    }
}
