package pl.janusz.zooce;

import java.util.Arrays;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class MergeSort extends Sorters {

    @Override
    public void sort(Integer[] array) {

        mergeSort(array, 0, array.length);
    }

    private void mergeSort(Integer[] array, int left, int right) {

        if (right - left < 2) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid, right);

        merge(array, left, right);
    }

    private void merge(Integer[] array, int left, int right) {

        Integer[] temp = new Integer[right - left];
        int mid = (left + right) / 2;
        int lSlider = left;
        int rSlider = mid;
        int slider = 0;
        while (lSlider < mid && rSlider < right) {
            if (array[lSlider] < array[rSlider]) {
                temp[slider] = array[lSlider];
                lSlider++;
            } else {
                temp[slider] = array[rSlider];
                rSlider++;
            }
            slider++;
        }

        while (lSlider < mid) {
            temp[slider] = array[lSlider];
            lSlider++;
            slider++;
        }

        while (rSlider < right) {
            temp[slider] = array[rSlider];
            rSlider++;
            slider++;
        }

        System.arraycopy(temp, 0, array, left, right - left);
    }
}
