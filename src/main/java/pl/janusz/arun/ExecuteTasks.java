package pl.janusz.arun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class ExecuteTasks {

    public static void main(String[] args) {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        final List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            threads.add(new Thread(new Task()));
        }

        threads
                .forEach(executorService::execute);

        executorService.shutdown();
        System.out.println("Waiting to shut down when all tasks have finished");
        executorService.shutdownNow();
    }

    private static class Task implements Runnable {

        @Override
        public void run() {

            while (true) {
                try {
                    final int timeout = ThreadLocalRandom.current().nextInt(2000);
                    TimeUnit.MILLISECONDS.sleep(timeout);
                    String format = String.format("%s slept %d s", Thread.currentThread().getName(), timeout);
                    System.out.println(format);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
