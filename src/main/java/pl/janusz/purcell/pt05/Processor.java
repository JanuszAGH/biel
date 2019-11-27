package pl.janusz.purcell.pt05;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class Processor implements Runnable {

    private int id;

    public Processor(int id) {

        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("Starting " + id);
        try {
            TimeUnit.MILLISECONDS.sleep(5_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed " + id);
    }
}
