package pl.janusz.purcell.pt02;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class ShutDown {

    public static void main(String[] args) throws InterruptedException {

        final Task task = new Task();
        final Thread thread = new Thread(task);
        thread.start();

        TimeUnit.SECONDS.sleep(3);
        task.shutDown();
    }

    private static class Task implements Runnable {

        private volatile boolean stop = false;

        public void shutDown() {

            stop = true;
        }

        @Override
        public void run() {

            while (!stop) {
                System.out.println("Hello");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
