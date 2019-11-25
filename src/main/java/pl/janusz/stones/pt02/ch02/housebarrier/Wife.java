package pl.janusz.stones.pt02.ch02.housebarrier;

import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class Wife implements Runnable {

    private Fridge fridge;
    private CyclicBarrier barrier;

    public Wife(Fridge fridge, CyclicBarrier barrier) {

        this.fridge = fridge;
        this.barrier = barrier;
    }

    @Override
    public void run() {

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        fridge.addTwo();
    }
}
