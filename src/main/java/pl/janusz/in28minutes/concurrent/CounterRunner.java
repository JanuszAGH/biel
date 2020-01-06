package pl.janusz.in28minutes.concurrent;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class CounterRunner {

    public static final int NUMBER_OF_OPERATIONS = 10_000;
    public static final int BOUND = 10;

    public static void main(String[] args) throws InterruptedException {

        Counter counter;
        counter = new CounterNTS();
        counter = new CounterSyncThis();
        counter = new CounterLock();
        counter = new CounterReadWriteLock();
        counter = new CounterSemaphore();
        counter = new CounterAtomic();

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.invokeAll(Arrays.asList(new Incrementer(counter), new Decrementer(counter)));

        System.out.println(counter.getI());

        executorService.shutdown();
    }

    private static class Incrementer implements Callable<Void> {

        private Counter counter;

        public Incrementer(Counter counter) {

            this.counter = counter;
        }

        @Override
        public Void call() throws Exception {

            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                counter.increment();
                TimeUnit.MICROSECONDS.sleep(ThreadLocalRandom.current().nextInt(BOUND));
            }

            return null;
        }
    }

    private static class Decrementer implements Callable<Void> {

        private Counter counter;

        public Decrementer(Counter counter) {

            this.counter = counter;
        }

        @Override
        public Void call() throws Exception {

            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                counter.decrement();
                TimeUnit.NANOSECONDS.sleep(ThreadLocalRandom.current().nextInt(BOUND));
            }

            return null;
        }
    }
}
