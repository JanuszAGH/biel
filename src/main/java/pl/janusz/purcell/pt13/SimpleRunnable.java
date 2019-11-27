package pl.janusz.purcell.pt13;

import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public class SimpleRunnable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<?> hi = executorService.submit(new Runnable() {

            @Override
            public void run() {

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hi");
            }
        });

        Object o = hi.get();
        System.out.println(o);

        executorService.shutdown();
    }
}
