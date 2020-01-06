package pl.janusz.mycodeschool.binsearch;

/**
 * Created by Janusz Kacki on 13/12/2019. Project; bielmarcus
 */
public class Occurrence {

    private BinSearch binSearch;

    public int occurrence(Integer[] array, int key) {

        int idx = binSearch(array, 0, array.length, key);
        if (idx == -1) {
            return 0;
        }

        int occurredSoFar = 1;

        int firstLeft;
        int lastRight;
        firstLeft = findLeft(array, idx, key);
        lastRight = findRight(array, idx, key);

        occurredSoFar += lastRight - idx;
        occurredSoFar += idx - firstLeft;

        return occurredSoFar;
    }

    private int findRight(Integer[] array, int idx, int key) {

        int index = binSearch(array, idx + 1, array.length, key);
        while (index > -1) {
            index = binSearch(array, index + 1, array.length, key);
        }

        return index;
    }

    private int findLeft(Integer[] array, int idx, int key) {

        int index = binSearch(array, 0, idx, key);
        while (index > -1) {
            index = binSearch(array, 0, index, key);
        }

        return index;
    }

    private int binSearch(Integer[] array, int left, int right, int key) {

        int idx = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (key < array[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return idx;
    }
}
