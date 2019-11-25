package pl.janusz.stones.pt02.ch01;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class Consumer implements Callable<Void> {

    private Drop drop;

    public Consumer(Drop drop) {

        this.drop = drop;
    }

    @Override
    public Void call() throws Exception {

        Random random = new Random();
        for (String message = drop.take();
             !message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }
}
