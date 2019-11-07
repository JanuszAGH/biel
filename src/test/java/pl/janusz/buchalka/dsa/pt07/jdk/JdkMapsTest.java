package pl.janusz.buchalka.dsa.pt07.jdk;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class JdkMapsTest {

    @Test
    public void hashMapIterator() {

        Map<String, Integer> map = new HashMap<>(2);

        Integer a;
        a = map.put("A", 1);
        assertThat(a, is(nullValue()));
        a = map.put("A", 1);
        assertThat(a, is(1));
        map.put("B", 2);
        map.put("C", 3);

        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        Iterator<String> keyIterator = map.keySet().iterator();
        Iterator<Integer> valuesIterator = map.values().iterator();

        final Set<Map.Entry<String, Integer>> entries = map.entrySet();
        final Set<String> keySet = map.keySet();
        final Collection<Integer> values = map.values();

        assertThat(keySet, hasItem("A"));
        assertThat(keySet, hasItems("C", "B"));
        final String[] strings = {"A", "B", "C"};
        assertThat(keySet, containsInAnyOrder(strings));
        assertThat(keySet, contains(strings));
    }

    @Test
    public void linkedMap() {

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        map.put("J", 10);
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        final Collection<Integer> values = map.values();
        assertThat(values, contains(6, 7, 8, 9, 10, 1, 2, 3, 4, 5));
    }

    @Test
    public void linkedMapRemovelastElement() {

        LinkedHashMap<String, Integer> map =
                new LinkedHashMap<String, Integer>() {

                    private int MAX_SIZE = 5;

                    @Override
                    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {

                        return size() > MAX_SIZE;
                    }
                };
        Collection<Integer> values;

        map.put("F", 6);
        values = map.values();
        assertThat(values, contains(6));
        map.put("G", 7);
        values = map.values();
        assertThat(values, contains(6, 7));
        map.put("H", 8);
        values = map.values();
        assertThat(values, contains(6, 7, 8));
        map.put("I", 9);
        values = map.values();
        assertThat(values, contains(6, 7, 8, 9));
        map.put("J", 10);
        values = map.values();
        assertThat(values, contains(6, 7, 8, 9, 10));
        map.put("A", 1);
        values = map.values();
        assertThat(values, contains(7, 8, 9, 10, 1));
        map.put("B", 2);
        values = map.values();
        assertThat(values, contains(8, 9, 10, 1, 2));
        map.put("C", 3);
        values = map.values();
        assertThat(values, contains(9, 10, 1, 2, 3));
        map.put("D", 4);
        values = map.values();
        assertThat(values, contains(10, 1, 2, 3, 4));
        map.put("E", 5);
        values = map.values();
        assertThat(values, contains(1, 2, 3, 4, 5));
    }

    @Test
    public void hashMap
            () {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("F", 6);
        assertThat(map.size(), is(1));
        map.put("G", 7);
        assertThat(map.size(), is(2));
        map.put("H", 8);
        assertThat(map.size(), is(3));
        map.put("I", 9);
        assertThat(map.size(), is(4));
        map.put("J", 10);
        assertThat(map.size(), is(5));
        map.put("A", 1);
        assertThat(map.size(), is(6));
        map.put("B", 2);
        assertThat(map.size(), is(7));
        map.put("C", 3);
        assertThat(map.size(), is(8));
        map.put("D", 4);
        assertThat(map.size(), is(9));
        map.put("E", 5);
        assertThat(map.size(), is(10));

        Collection<Integer> values;
        values = map.values();
        assertThat(values, not(contains(6, 7, 8, 9, 10, 1, 2, 3, 4, 5)));
        assertThat(values, containsInAnyOrder(6, 7, 8, 9, 10, 1, 2, 3, 4, 5));
    }
}