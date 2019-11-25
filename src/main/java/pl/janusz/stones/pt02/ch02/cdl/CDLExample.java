package pl.janusz.stones.pt02.ch02.cdl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CDLExample {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);
        final Thread first = new Thread(new Task("First", latch));
        final Thread second = new Thread(new Task("Second", latch));
        final Thread third = new Thread(new Task("Third", latch));
        final Thread main = new Thread(new MainTask(latch));

        main.start();
        first.start();
        second.start();
        third.start();
    }

    private static class Task implements Runnable {

        private String name;
        private CountDownLatch latch;

        public Task(String name, CountDownLatch latch) {

            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
            System.out.println(name + " finished");
        }
    }

    private static class MainTask implements Runnable {

        private CountDownLatch latch;

        public MainTask(CountDownLatch latch) {

            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                latch.await(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Main task finished");
        }
    }
}
