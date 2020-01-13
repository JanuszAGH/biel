package pl.janusz.mit6006.lec01;

/**
 * Created by Janusz Kacki on 06/01/2020. Project; bielmarcus
 */
public class FindPeak2D {

    public static int findPeak(Integer[] array) {

        return recFindPeak(array, 0, array.length);
    }

    private static int recFindPeak(Integer[] array, int left, int right) {

        int mid = left + (right - left) / 2;

        if (mid == 0 && array[mid] >= array[mid + 1]) {
            return mid;
        }

        if (mid == array.length - 1 && array[mid - 1] <= array[mid]) {
            return mid;
        }

        if (array[mid - 1] <= array[mid] && array[mid] >= array[mid + 1]) {
            return mid;
        }

        if (array[mid - 1] > array[mid]) {
            return recFindPeak(array, left, mid);
        } else {
            return recFindPeak(array, mid + 1, right);
        }
    }
}
