package pl.janusz.zooce;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class QuickSort extends Sorters {

    @Override
    public void sort(Integer[] array) {

        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(Integer[] array, int left, int right) {

        if ((right - left < 1)) {
            return;
        }

        int pivot = partition(array, left, right);
        mergeSort(array, left, pivot - 1);
        mergeSort(array, pivot + 1, right);
    }

    private int partition(Integer[] array, int left, int right) {

        int pivot = array[right];

        int slider = left;
        int temp;

        for (int i = left; i < right ; i++) {
            if (array[i] < pivot) {
                temp = array[slider];
                array[slider] = array[i];
                array[i] = temp;
                slider++;
            }
        }

        temp = array[slider];
        array[slider] = array[right];
        array[right] = temp;

        return slider;
    }
}
