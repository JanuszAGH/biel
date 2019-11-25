package pl.janusz.stones.pt02.ch04.benchamark;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class Sum extends RecursiveTask<Long> {

    private Integer[] array;
    private int left;
    private int right;
    private int threshold;

    public Sum(Integer[] array, int left, int right, int threshold) {

        this.array = array;
        this.left = left;
        this.right = right;
        this.threshold = threshold;
    }

    @Override
    protected Long compute() {

        if (right - left <= threshold) {
            return sequentialSum();
        } else {
            return parallelledSum();
        }
    }

    private Long parallelledSum() {

        int mid = (left + right) / 2;

        final Sum leftTask = new Sum(array, left, mid, threshold);
        final Sum rightTask = new Sum(array, mid, right, threshold);

        leftTask.fork();
        final Long compute = rightTask.compute();
        final Long join = leftTask.join();

        return compute + join;
    }

    private Long sequentialSum() {

        Long sum = 0L;
        for (int i = left; i < right; i++) {
            sum += array[i];
        }

        return sum;
    }
}
