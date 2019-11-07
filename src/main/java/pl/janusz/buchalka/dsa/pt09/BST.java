package pl.janusz.buchalka.dsa.pt09;

import java.util.Iterator;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public interface BST<E extends Comparable<? super E>> extends Iterable<E> {

    void insert(E element);

    void delete(E element);

    boolean contains(E element);

    E min();

    E max();

    Iterator<E> iterator();

    boolean isBST();
}
