package pl.janusz.buchalka.dsa.pt06;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public interface Queue<E> {

    void add(E element);

    E remove();

    E peek();

    int size();

    boolean isEmpty();

    void clear();
}
