package pl.janusz.arun;

import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class UseFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        final Doubler doubler = new Doubler();
        final Future<Integer> future = executorService.submit(doubler);
        System.out.println("submitted");
        System.out.println(future.get());

        executorService
                .shutdown();
    }

    private static class Doubler implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {

            System.out.println(Thread.currentThread().getName()+" started");
            final int i = ThreadLocalRandom.current().nextInt(1000);
            TimeUnit.MILLISECONDS.sleep(i + 3000);
            System.out.println(Thread.currentThread().getName()+" finished");

            return 2 * i;
        }
    }
}
