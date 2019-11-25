package pl.janusz.purcell.pt04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class Worker {

    private static final int MAX_ITERATIONS = 1_000;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    private static final List<Integer> list1 = new ArrayList<>();
    private static final List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        final Runnable target = Worker::process;

        final Thread thread1 = new Thread(target);
        final Thread thread2 = new Thread(target);
        final Thread thread3 = new Thread(target);
        final Thread thread4 = new Thread(target);
        List<Thread> threads = Arrays.asList(thread1, thread2, thread3, thread4);

        final long start = System.nanoTime();
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        final long end = System.nanoTime();
        final long duration = (end - start) / 1_000_000;
        System.out.println(duration);
        final Integer sum1 = list1.stream().reduce(Integer::sum).orElse(0);
        final int sum2 = list2.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2 - sum1);
    }

    public static void stageOne() {

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (lock1) {
            list1.add(3);
        }
    }

    public static void stageTwo() {

        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        synchronized (lock2) {
            list2.add(3);
        }
    }

    public static void process() {

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            stageOne();
            stageTwo();
        }
    }
}
