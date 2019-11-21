package pl.janusz.ahmad.multithreading.executors;

import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class ExecuteCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        final Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {

                try {
                    System.out.println(Thread.currentThread().getName() + " will sleep");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + " has been woken up");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                return Thread.currentThread().getName();
            }
        };

        final Future<String> future = executorService.submit(callable);
        System.out.println("Callable submitted");

        System.out.println("Will wait for geting a result");
        final String s = future.get();
        System.out.println(s);
        System.out.println("Done");

        executorService.shutdown();
    }
}
