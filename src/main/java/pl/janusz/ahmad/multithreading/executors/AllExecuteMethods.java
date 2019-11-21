package pl.janusz.ahmad.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class AllExecuteMethods {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        final Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        executorService.execute(runnable);

        final Callable<String> task = new Callable<String>() {

            @Override
            public String call() throws Exception {

                return Thread.currentThread().getName();
            }
        };
        final Future<String> submit = executorService.submit(task);
        System.out.println(submit.get());

        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final String key = Integer.toString(i);
            callables.add(new Callable<String>() {

                @Override
                public String call() throws Exception {

                    final int sleepTime = ThreadLocalRandom.current().nextInt(10000);
                    System.out.println(Thread.currentThread().getName() + " will sleep " + sleepTime);
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                    System.out.println(Thread.currentThread().getName() + " slept " + sleepTime);
                    return key + " : " + Thread.currentThread().getName() + " slept " + sleepTime;
                }
            });
        }

        final String s = executorService.invokeAny(callables);
        System.out.println("Invoked");
        System.out.println(s);

//        final List<Future<String>> futures = executorService.invokeAll(callables);
//        for (Future<String> future : futures) {
//            final String fStr = future.get();
//            System.out.println(fStr);
//        }

        executorService
                .shutdown();
    }
}
