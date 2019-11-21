package pl.janusz.stones.pt01.ch03;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class Decrementer implements Callable<Void> {

    private Counter counter;

    public Decrementer(Counter counter) {

        this.counter = counter;
    }

    @Override
    public Void call() {

        for (int i = 0; i < 1_000; i++) {
            final int sleepTime = ThreadLocalRandom.current().nextInt(100);
            counter.dec();
            try {
                TimeUnit.MICROSECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("DEC finished");

        return null;
    }
}
