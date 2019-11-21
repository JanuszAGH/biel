package pl.janusz.stones.pt01.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class Recursion {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Fibonacci> calalbles = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            final Fibonacci callable = new Fibonacci(i);
            calalbles.add(callable);
        }

        final List<Future<Long[]>> futures = executorService.invokeAll(calalbles);

        for (Future<Long[]> future : futures) {
            final Long[] longs = future.get();
            System.out.println(Arrays.toString(longs));
        }
        System.out.println();

        executorService.shutdown();
    }

    private static class Fibonacci implements Callable<Long[]> {

        private int n;

        public Fibonacci(int n) {

            this.n = n;
        }

        @Override
        public Long[] call() throws Exception {

            Long[] result;
            final Long fibon = fibon(n);
            result = new Long[]{(long) n, fibon};
            return result;
        }

        private Long fibon(int n) {

            if (n < 2) {
                return (long) n;
            }

            Long fibon1 = fibon(n - 1);
            Long fibon2 = fibon(n - 2);

            return fibon1 + fibon2;
        }
    }
}
