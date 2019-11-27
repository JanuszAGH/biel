package pl.janusz.purcell.pt06;

import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 26/11/2019. Project; bielmarcus
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Processor(latch));
        }

        latch.await();
        System.out.println("Finisged all 3");

        executorService.shutdown();
    }
}

class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {

        this.latch = latch;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " started");
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(5000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
        latch.countDown();
    }
}
