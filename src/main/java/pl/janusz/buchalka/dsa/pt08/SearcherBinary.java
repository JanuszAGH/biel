package pl.janusz.buchalka.dsa.pt08;

import java.util.Arrays;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class SearcherBinary implements Searcher {

    @Override
    public int search(Integer[] array, Integer lookup) {

        int left = 0;
        int right = array.length;
        int mid;

        Arrays.sort(array);

        while (left < right) {
            mid = (left + right) / 2;

            if (lookup.compareTo(array[mid]) == 0) {
                return mid;
            }

            if (lookup.compareTo(array[mid]) < 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
