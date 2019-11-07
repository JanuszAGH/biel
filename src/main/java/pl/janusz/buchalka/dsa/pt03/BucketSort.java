package pl.janusz.buchalka.dsa.pt03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BucketSort {

    public static final int INITIAL_CAPACITY = 10;

    public static void sort(Integer[] array) {

        List<List<Integer>> buckets = new ArrayList<>(INITIAL_CAPACITY);

        for (int i = 0; i < INITIAL_CAPACITY; i++) {

            buckets.add(new ArrayList<>());
        }

        for (Integer integer : array) {
            final int hash = hash(integer);
            final List<Integer> bucket = buckets.get(hash);
            bucket.add(integer);
        }

        for (List<Integer> bucket : buckets) {
            bucket.sort(Integer::compareTo);
        }

        final ArrayList<Integer> sorted = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            sorted.addAll(bucket);
        }
        sorted.toArray(array);
    }

    private static int hash(Integer integer) {

        if (integer < 0) {
            return 0;
        }

        if (integer / 10 >= INITIAL_CAPACITY) {
            return INITIAL_CAPACITY - 1;
        }

        return integer / INITIAL_CAPACITY;
    }
}
