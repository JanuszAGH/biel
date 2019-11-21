package pl.janusz.ahmad.multithreading.interrupt;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class LetsInterruptThread {

    public static void main(String[] args) {

        final Thread thread = new Thread(new Worker());
        thread.start();
        thread.interrupt();
    }

    private static class Worker implements Runnable {

        @Override
        public void run() {

            while (true) {
                System.out.println(LocalTime.now());
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    if (Thread.interrupted()) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException();
                    }
                    System.out.println("Interrupted while sleeping");
                }
            }
        }
    }
}
