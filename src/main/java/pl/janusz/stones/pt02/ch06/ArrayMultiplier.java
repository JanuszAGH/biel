package pl.janusz.stones.pt02.ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public final class ArrayMultiplier {

    private ArrayMultiplier() {

    }

    public static Integer[][] multiply(Integer[][] a, Integer[][] b) {

        if (a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        Integer[][] product = new Integer[a.length][b[0].length];

        for (int row = 0; row < product.length; row++) {
            for (int column = 0; column < product[0].length; column++) {
                product[row][column] = calculateCell(row, column, a, b);
            }
        }

        return product;
    }

    public static Integer[][] multiplyParallelly(Integer[][] a, Integer[][] b) {

        class FillArray extends RecursiveAction {

            private Integer[][] product;
            private Integer[][] a;
            private Integer[][] b;
            private int start;
            private int end;

            public FillArray(Integer[][] product, Integer[][] a, Integer[][] b, int start, int end) {

                this.product = product;
                this.a = a;
                this.b = b;
                this.start = start;
                this.end = end;
            }

            @Override
            protected void compute() {

                for (int row = start; row < end; row++) {
                    for (int column = 0; column < product[0].length; column++) {
                        product[row][column] = calculateCell(row, column, a, b);
                    }
                }
            }
        }

        if (a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        Integer[][] product = new Integer[a.length][b[0].length];

        final ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        int numberOfTasks = Runtime.getRuntime().availableProcessors();
        final int step = (int) Math.ceil(product.length / numberOfTasks);
        List<FillArray> actions = new ArrayList<>();
        for (int i = 0; i < numberOfTasks - 1; i++) {
            actions.add(new FillArray(product, a, b, i, i + step));
        }
        actions.add(new FillArray(product, a, b, (numberOfTasks - 1) * step, product.length));

        for (FillArray action : actions) {
            forkJoinPool.invoke(action);
        }

        forkJoinPool.shutdown();

        return product;
    }

    private static Integer calculateCell(int row, int column, Integer[][] a, Integer[][] b) {

        Integer sum = 0;

        for (int i = 0; i < a[0].length; i++) {
            sum += a[row][i] * b[i][column];
        }

        return sum;
    }
}
