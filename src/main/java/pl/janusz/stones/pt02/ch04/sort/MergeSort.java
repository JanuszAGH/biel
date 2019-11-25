package pl.janusz.stones.pt02.ch04.sort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public final class MergeSort {

    public MergeSort() {

    }

    public static void sort(Integer[] array) {

        mergeSortParallel(array, 0, array.length);
    }

    private static void mergeSortParallel(Integer[] array, int left, int right) {

        final int THRESHOLD = 4;

        class SortRecursiveAction extends RecursiveAction {

            private Integer[] array;
            private int left;
            private int right;

            public SortRecursiveAction(Integer[] array, int left, int right) {

                this.array = array;
                this.left = left;
                this.right = right;
            }

            @Override
            protected void compute() {

                if (right - left < THRESHOLD) {
                    mergeSort(array, left, right);
                } else {
                    parallelSort(array, left, right);
                }
            }

            private void parallelSort(Integer[] array, int left, int right) {

                int mid = (left + right) / 2;
                final SortRecursiveAction leftSort = new SortRecursiveAction(array, left, mid);
                final SortRecursiveAction rightSort = new SortRecursiveAction(array, mid, right);

                invokeAll(leftSort, rightSort);
                merge(array, left, right);
            }
        }

        final ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        forkJoinPool.invoke(new SortRecursiveAction(array, left, right));

        forkJoinPool.shutdown();
    }

    private static void mergeSort(Integer[] array, int left, int right) {

        if (right - left < 2) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid, right);

        merge(array, left, right);
    }

    private static void merge(Integer[] array, int left, int right) {

        int mid = (left + right) / 2;

        int leftSlider = left;
        int rightSLider = mid;
        int slider = 0;
        Integer[] temp = new Integer[right - left];

        while (leftSlider < mid && rightSLider < right) {
            if (array[leftSlider] < array[rightSLider]) {
                temp[slider] = array[leftSlider++];
            } else {
                temp[slider] = array[rightSLider++];
            }
            slider++;
        }

        while (leftSlider < mid) {
            temp[slider] = array[leftSlider];
            slider++;
            leftSlider++;
        }

        while (rightSLider < right) {
            temp[slider] = array[rightSLider];
            slider++;
            rightSLider++;
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
