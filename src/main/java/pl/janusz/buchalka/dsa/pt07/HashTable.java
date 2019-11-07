package pl.janusz.buchalka.dsa.pt07;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public interface HashTable<K, V> {

    void put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();
}
