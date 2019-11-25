package pl.janusz.stones.pt02.ch06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class ArrayIncrementer {

    private final static int THRESHOLD = 4;

    public static void increment(Integer[] array, int value) {

        parallelIncrement(array, 0, array.length, value);
    }

    private static void parallelIncrement(Integer[] array, int left, int right, int value) {

        final ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        forkJoinPool.invoke(new IncRecursiveTask(array, 0, array.length, value));

        forkJoinPool.shutdown();
    }

    private static class IncRecursiveTask extends RecursiveAction {

        private Integer[] array;
        private int left;
        private int right;
        private int value;

        public IncRecursiveTask(Integer[] array, int left, int right, int value) {

            this.array = array;
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        protected void compute() {

            if (right - left < THRESHOLD) {
                for (int i = left; i < right; i++) {
                    array[i] += value;
                }
            } else {
                final int mid = (left + right) / 2;
                final IncRecursiveTask leftAction = new IncRecursiveTask(array, left, mid, value);
                final IncRecursiveTask rightAction = new IncRecursiveTask(array, mid, right, value);
                invokeAll(leftAction, rightAction);
            }
        }
    }
}
