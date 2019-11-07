package pl.janusz.buchalka.dsa.pt05;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public interface Stack<E> {

    void push(E element);

    E pop();

    E peek();

    int size();

    boolean isEmpty();

    void clear();
}
