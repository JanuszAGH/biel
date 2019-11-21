package pl.janusz.ahmad.multithreading.counter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class Decrementer implements Runnable {

    private Counter counter;

    public Decrementer(Counter counter) {

        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5_000; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(ThreadLocalRandom.current().nextInt(250));
                counter.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
