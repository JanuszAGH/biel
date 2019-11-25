package pl.janusz.purcell.pt03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class CounterApp {

    private static final int NUMBER_OF_REPETITIONS = 1_000_000;

    private static Lock lock = new ReentrantLock();

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {

        final Thread threadInc = new Thread(new Incrementer());
        final Thread threadDec = new Thread(new Decrementer());

        threadDec.start();
        threadInc.start();

        threadDec.join();
        threadInc.join();
        System.out.println(count);
    }

    private static class Incrementer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < NUMBER_OF_REPETITIONS; i++) {

                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class Decrementer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < NUMBER_OF_REPETITIONS; i++) {

                lock.lock();
                try {
                    count--;
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
