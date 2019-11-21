package pl.janusz.ahmad.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class ExecuteRunnable {

    public static void main(String[] args) {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        final Runnable runnable = new Runnable() {

            @Override
            public void run() {

                try {
                    System.out.println(Thread.currentThread().getName() + " will sleep");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " has been woken up");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        executorService.execute(runnable);
        System.out.println("Runnable sended");

        executorService.shutdown();
    }
}
