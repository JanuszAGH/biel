package pl.janusz.mycodeschool.binsearch;

/**
 * Created by Janusz Kacki on 13/12/2019. Project; bielmarcus
 */
public class BinSearchImplIter implements BinSearch {

    @Override
    public int search(Integer[] array, int key) {

        int left = 0;
        int right = array.length;

        while (right != left) {
            int mid = (right + left) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (key < array[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
