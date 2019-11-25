package pl.janusz.stones.pt02.ch04.sum;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class Sum extends RecursiveTask<Long> {

    //    private final static int THRESHOLD_SIZE = 10_000;
    private final static int THRESHOLD_SIZE = 2;
    private Integer[] array;
    private int left;
    private int right;

    public Sum(Integer[] array, int left, int right) {

        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected Long compute() {

        if (right - left < THRESHOLD_SIZE) {
            return conputeSequentially();
        }

        return computeParallelly();
    }

    private Long computeParallelly() {

        int mid = (left + right) / 2;

        final Sum leftSumTask = new Sum(array, left, mid);
        final Sum rightSumTask = new Sum(array, mid, right);

        leftSumTask.fork();
        final Long rightSum = rightSumTask.compute();
        final Long leftSum = leftSumTask.join();

        return leftSum + rightSum;
    }

    private Long conputeSequentially() {

        Long sum = 0L;
        for (int i = left; i < right; i++) {
            sum += array[i];
        }
        return sum;
    }
}
