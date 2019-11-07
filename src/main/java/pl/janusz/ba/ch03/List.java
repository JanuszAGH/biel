package pl.janusz.ba.ch03;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public interface List<E> extends Iterable<E> {

    void add(int index, E value) throws IndexOutOfBoundsException;

    void add(E value);

    E remove(int index) throws IndexOutOfBoundsException;

    boolean remove(E e);

    Object get(int index) throws IndexOutOfBoundsException;

    Object set(int index, E value) throws IndexOutOfBoundsException;

    void clear();

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    int indexOf(Object o);

    Iterator<E> iterator();
}
