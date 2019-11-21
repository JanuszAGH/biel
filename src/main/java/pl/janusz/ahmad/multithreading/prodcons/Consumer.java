package pl.janusz.ahmad.multithreading.prodcons;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class Consumer implements Runnable {

    private Basket basket;

    public Consumer(Basket basket) {

        this.basket = basket;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
                System.out.println("Took " + basket.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
