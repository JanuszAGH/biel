package pl.janusz.buchalka.dsa.pt08;

import java.util.Arrays;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class SearcherBinaryRecursive implements Searcher {

    @Override
    public int search(Integer[] array, Integer key) {

        Arrays.sort(array);

        return recBinSearch(array, key, 0, array.length);
    }

    private int recBinSearch(Integer[] array, Integer key, int left, int right) {

        if (left == right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (key.compareTo(array[mid]) == 0) {
            return mid;
        }

        if (key.compareTo(array[mid]) < 0) {
            return recBinSearch(array, key, left, mid);
        } else {
            return recBinSearch(array, key, mid + 1, right);
        }
    }
}
