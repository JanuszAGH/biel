package pl.janusz.buchalka.dsa.pt10;

/**
 * Created by Janusz Kacki on 06/11/2019. Project; bielmarcus
 */
public interface Heap<E extends Comparable<? super E>> {

    void insert(E element);

    E delete();

    E peek();

    boolean isEmpty();
}
