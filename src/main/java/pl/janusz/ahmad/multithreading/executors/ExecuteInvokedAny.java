package pl.janusz.ahmad.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class ExecuteInvokedAny {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 3; i > 0; i--) {
            final int time = i;
            final Callable<String> callable = new Callable<String>() {

                @Override
                public String call() throws Exception {

                    try {
                        System.out.println(Thread.currentThread().getName() + " will sleep");
                        if (time != 1) {
                            TimeUnit.SECONDS.sleep(2 + time);
                        } else {

                            TimeUnit.SECONDS.sleep(10);
                        }
                        System.out.println(Thread.currentThread().getName() + " has been woken up");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    return Thread.currentThread().getName();
                }
            };

            callables.add(callable);
        }

        System.out.println("Will ivoke");
        final String s = executorService.invokeAny(callables);
        System.out.println("Ivoked");

        System.out.println(s);

        executorService.shutdown();
    }
}

