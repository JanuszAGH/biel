package pl.janusz.ahmad.multithreading.prodcons;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class Producer implements Runnable {

    private Basket basket;

    public Producer(Basket basket) {

        this.basket = basket;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
//                System.out.println("Putting element " + (i + 1));
                basket.put("Element " + (i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
