package pl.janusz.purcell.pt13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public class CounterCallables {

    private static final int NUMBER_OF_OPERATIOSNS = 277;
    private static final int NUMBER_OF_THREADS = 31;

    public static void main(String[] args) throws InterruptedException {

        new CounterCallables().helper();
    }

    private void helper() throws InterruptedException {

        Counter counter = new Counter();
        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            callables.add(new Incrementer(counter));
            callables.add(new Decrementer(counter));
        }
        executorService.invokeAll(callables);
        System.out.println(counter.getValue());

        executorService.shutdown();
    }

    private class Incrementer implements Callable<Void> {

        private Counter counter;

        public Incrementer(Counter counter) {

            this.counter = counter;
        }

        @Override
        public Void call() throws Exception {

            for (int i = 0; i < NUMBER_OF_OPERATIOSNS; i++) {
                counter.inc();
                TimeUnit.NANOSECONDS.sleep(ThreadLocalRandom.current().nextInt(929));
            }

            return null;
        }
    }

    private class Decrementer implements Callable<Void> {

        private Counter counter;

        public Decrementer(Counter counter) {

            this.counter = counter;
        }

        @Override
        public Void call() throws Exception {

            for (int i = 0; i < NUMBER_OF_OPERATIOSNS; i++) {
                counter.dec();
                TimeUnit.NANOSECONDS.sleep(ThreadLocalRandom.current().nextInt(809));
            }

            return null;
        }
    }

    private class Counter {

        private int value;
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void inc() {

            readWriteLock.writeLock().lock();
            try {
                value++;
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

        public void dec() {

            readWriteLock.writeLock().lock();
            try {
                value--;
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

        public int getValue() {

            readWriteLock.readLock().lock();
            try {
                return value;
            } finally {
                readWriteLock.readLock().unlock();
            }
        }
    }
}
