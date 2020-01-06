package pl.janusz.mycodeschool.binsearch;

/**
 * Created by Janusz Kacki on 13/12/2019. Project; bielmarcus
 */
public class BinSearchImplRec implements BinSearch {

    @Override
    public int search(Integer[] array, int key) {

        return recBinSrch(array, 0, array.length, key);
    }

    private int recBinSrch(Integer[] array, int left, int right, int key) {

        if (left == right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (array[mid] == key) {
            return mid;
        }

        if (key < array[mid]) {
            return recBinSrch(array, left, mid, key);
        } else {
            return recBinSrch(array, mid + 1, right, key);
        }
    }
}
