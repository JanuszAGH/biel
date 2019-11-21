package pl.janusz.ahmad.multithreading.producerconsumer;

import java.util.Random;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class Consumer implements Runnable {

    private Drop drop;

    public Consumer(Drop drop) {

        this.drop = drop;
    }

    public void run() {

        Random random = new Random();
        for (String message = drop.take();
             !message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }
        }
    }
}
