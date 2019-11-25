package pl.janusz.stones.pt02.ch02.hoselatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class Wife implements Runnable {

    private Fridge fridge;
    private CountDownLatch latch;

    public Wife(Fridge fridge, CountDownLatch latch) {

        this.fridge = fridge;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fridge.addTwo();
    }
}
