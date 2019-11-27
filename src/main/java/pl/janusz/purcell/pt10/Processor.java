package pl.janusz.purcell.pt10;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 26/11/2019. Project; bielmarcus
 */
public class Processor {

    private static final int LIMIT = 10;

    private static final Lock lock = new ReentrantLock();
    private static final Condition inCondition = lock.newCondition();
    private static final Condition outCondition = lock.newCondition();
    private static final Random random = new Random();

    private static final LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.execute(Processor::produce);
        executorService.execute(Processor::consume);

        executorService.shutdown();
    }

    public static void produce() {

        int value = 0;
        while (true) {
            lock.lock();
            try {
                while (list.size() > LIMIT) {
                    try {
                        inCondition.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                list.add(++value);
                outCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void consume() {

        while (true) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            lock.lock();
            try {

                while (list.size() <= 0) {
                    try {
                        outCondition.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                final Integer value = list.removeFirst();
                System.out.println("List size is: " + list.size() + ", value is: " + value);
                inCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
