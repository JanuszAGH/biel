package pl.janusz.purcell.pt14;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public class BusyTask {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 1E8; i++) {
                    double sin = Math.sin(ThreadLocalRandom.current().nextDouble() * Math.PI);
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                }
                System.out.println("Calculations has been finished");
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

        thread.join();
        System.out.println("Done");
    }
}
