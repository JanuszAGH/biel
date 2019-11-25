package pl.janusz.stones.pt02.ch04;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class Chopper implements Runnable {

    @Override
    public void run() {

        final String format = String.format("Thread %s chopped vegetables", Thread.currentThread().getName());
        System.out.println(format);

        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(50));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
