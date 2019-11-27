package pl.janusz.purcell.pt12;

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

    private static final Random random = new Random();
    private static final LinkedList<Integer> list = new LinkedList<>();
    private static Semaphore inSemaphore = new CountingSemaphore(1);
    private static Semaphore outSemaphore = new CountingSemaphore(1);

    public static void main(String[] args) {

        outSemaphore.setAvailableSlots(0);

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.execute(Processor::produce);
        executorService.execute(Processor::consume);

        executorService.shutdown();
    }

    public static void produce() {

        int value = 0;
        while (true) {
            inSemaphore.acquire();
            list.add(++value);
            outSemaphore.release();
        }
    }

    public static void consume() {

        while (true) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            outSemaphore.acquire();
            final Integer value = list.removeFirst();
            System.out.println("List size is: " + list.size() + ", value is: " + value);
            inSemaphore.release();
        }
    }
}