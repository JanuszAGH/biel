package pl.janusz.ba.ch03;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

    void remove();
}
