package pl.janusz.buchalka.dsa.pt07;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class HashTableChaining<K, V> implements HashTable<K, V> {

    private List<Entry<K, V>>[] array;

    private double LOAD_FACTOR = 0.75;
    private int INITIAL_CAPACITY = 4;
    private int size;

    public HashTableChaining() {

        array = new List[INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {

        assureCapacity();

        int slot = hashKey(key);

        if (array[slot] == null) {
            array[slot] = new LinkedList<>();
        }

        array[slot].add(new Entry<>(key, value));

        size++;
    }

    private void assureCapacity() {

        if (size() / array.length > LOAD_FACTOR) {
            final List[] newArray = new List[INITIAL_CAPACITY * 2];
            final List[] oldArray = array;
            array = newArray;
            size = 0;

            for (List oldList : oldArray) {
                if (oldList != null) {
                    for (int i = 0; i < oldList.size(); i++) {
                        Entry<K, V> entry = (Entry<K, V>) oldList.get(i);
                        put(entry.key, entry.value);
                    }
                }
            }
        }
    }

    @Override
    public V get(K key) {

        V val = null;
        final int slot = hashKey(key);
        if (array[slot] != null) {
            Entry<K, V> entry = getEntryFromEntries(key, array[slot]);
            if (entry != null) {
                val = entry.value;
            }
        }

        return val;
    }

    private Entry<K, V> getEntryFromEntries(K key, List<Entry<K, V>> entries) {

        for (Entry<K, V> entry : entries) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {

        V val = null;
        final int slot = hashKey(key);
        if (array[slot] != null) {
            Entry<K, V> entry = getEntryFromEntries(key, array[slot]);
            if (entry != null) {
                val = entry.value;
                array[slot].remove(entry);
                size--;
            }
        }

        return val;
    }

    @Override
    public int size() {

        return size;
    }

    private int hashKey(K key) {

        return ((String) key).length() % array.length;
    }

    private class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {

            this.key = key;
            this.value = value;
        }
    }
}
