package pl.janusz.buchalka.dsa.pt09;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BinarySearchTreeRecursive<E extends Comparable<? super E>> implements BST<E> {

    private Node<E> root;

    @Override
    public void insert(E element) {

        if (contains(element)) {
            return;
        }

        root = insertRec(root, element);
    }

    @Override
    public void delete(E element) {

        root = deleteRec(root, element);
    }

    private Node<E> deleteRec(Node<E> node, E key) {

        if (node == null) {
            return node;
        }

        if (key.compareTo(node.element) != 0) {
            if (key.compareTo(node.element) < 0) {
                node.left = deleteRec(node.left, key);
            } else {
                node.right = deleteRec(node.right, key);
            }

            return node;
        }

        if (node.left == null && node.right == null) {
            return null;
        }

        if (node.left != null && node.right != null) {
            final E maxElement = recMax(node.left);
            node.element = maxElement;
            node.left = deleteRec(node.left, maxElement);

            return node;
        }

        if (node.left == null) {
            return node.right;
        }

        return node.left;
    }

    @Override
    public boolean contains(E element) {

        return findRec(root, element);
    }

    @Override
    public E min() {

        if (root == null) {
            return null;
        }

        return recMin(root);
    }

    private E recMin(Node<E> node) {

        if (node.left == null) {
            return node.element;
        }

        return recMin(node.left);
    }

    @Override
    public E max() {

        if (root == null) {
            return null;
        }

        return recMax(root);
    }

    private E recMax(Node<E> node) {

        if (node.right == null) {
            return node.element;
        }

        return recMax(node.right);
    }

    private boolean findRec(Node<E> node, E element) {

        if (node == null) {
            return false;
        }

        if (element.compareTo(node.element) == 0) {
            return true;
        }

        if (element.compareTo(node.element) < 0) {
            return findRec(node.left, element);
        } else {
            return findRec(node.right, element);
        }
    }

    private Node<E> insertRec(Node<E> node, E element) {

        if (node == null) {
            return new Node<>(element);
        }

        if (element.compareTo(node.element) < 0) {
            node.left = insertRec(node.left, element);
        } else {
            node.right = insertRec(node.right, element);
        }

        return node;
    }

    @Override
    public Iterator<E> iterator() {

        return new InOrderIterator<>();
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

    private class Node<E> {

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
