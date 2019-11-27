package pl.janusz.purcell.pt07;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 26/11/2019. Project; bielmarcus
 */
public class App {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.execute(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

    private static void producer() throws InterruptedException {

        final Random random = new Random();
        while (true) {
            blockingQueue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {

        final Random random = new Random();
        while (true) {
            TimeUnit.MILLISECONDS.sleep(100);
            if (random.nextInt(10) == 0) {
                final Integer take = blockingQueue.take();
                System.out.println("Taken value " + take + " Queue size is " + blockingQueue.size());
            }
        }
    }
}
