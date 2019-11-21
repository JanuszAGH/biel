package pl.janusz.fisher.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class ToBeInterrupted {

    public static void main(String[] args) throws InterruptedException {

        final Thread thread = new Thread(() -> {
            while (true) {

//                if (Thread.currentThread().isInterrupted()) {
                if (Thread.interrupted()) {
                    System.out.println("Done");

                    return;
                }
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);

        thread.interrupt();
    }
}
