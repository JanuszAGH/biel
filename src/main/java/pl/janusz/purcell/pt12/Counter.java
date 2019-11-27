package pl.janusz.purcell.pt12;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public class Counter {

    private static final int LIMIT = 10_000;
    private static final CountDownLatch countDownLatch = new CountDownLatch(3);
    private static final Semaphore semaphore = new CountingSemaphore(1);
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.execute(() -> {
            try {
                increment();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        executorService.execute(() -> {
            try {
                increment();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        executorService.execute(() -> {
            try {
                decrement();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        executorService.execute(new Runnable() {

            @Override
            public void run() {

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(count);
            }
        });

        executorService.shutdown();

        TimeUnit.MICROSECONDS.sleep(10_000);

        System.out.println(count);
    }

    public static void increment() throws InterruptedException {

        for (int i = 0; i < LIMIT; i++) {
            semaphore.acquire();
            count++;
            semaphore.release();

            TimeUnit.MICROSECONDS.sleep(ThreadLocalRandom.current().nextInt(3));
        }

        countDownLatch.countDown();
    }

    public static void decrement() throws InterruptedException {

        for (int i = 0; i < LIMIT; i++) {
            semaphore.acquire();
            int value = count;
            value = value - 1;
            count = value;
            semaphore.release();

            TimeUnit.MICROSECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
        }

        countDownLatch.countDown();
    }
}
