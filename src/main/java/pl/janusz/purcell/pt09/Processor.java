package pl.janusz.purcell.pt09;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janusz Kacki on 26/11/2019. Project; bielmarcus
 */
public class Processor {

    private static final int LIMIT = 10;

    private static final Object lock = new Object();
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
            synchronized (lock) {
                while (list.size() > LIMIT) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                list.add(++value);
                lock.notifyAll();
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

            synchronized (lock) {
                while (list.size() <= 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                final Integer value = list.removeFirst();
                System.out.println("List size is: " + list.size() + ", value is: " + value);
                lock.notifyAll();
            }
        }
    }
}
