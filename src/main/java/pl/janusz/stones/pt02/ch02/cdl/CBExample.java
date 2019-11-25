package pl.janusz.stones.pt02.ch02.cdl;

import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CBExample {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {

            @Override
            public void run() {

                System.out.println("main");
            }
        });
        final Thread first = new Thread(new Task("First", barrier));
        final Thread second = new Thread(new Task("Second", barrier));
        final Thread third = new Thread(new Task("Third", barrier));
        final Thread fourth = new Thread(new Task("Fourth", barrier));
        final Thread fifth = new Thread(new Task("Fifth", barrier));
        final Thread sixtht = new Thread(new Task("Sixth", barrier));
        final Thread seventh = new Thread(new Task("Seventh", barrier));
        final Thread eighth = new Thread(new Task("Eighth", barrier));
        final Thread ninth = new Thread(new Task("Ninth", barrier));
        final Thread tenth = new Thread(new Task("Tenth", barrier));
        final Thread eleventh = new Thread(new Task("Eleventh", barrier));
        final Thread twelfth = new Thread(new Task("Twelfth", barrier));

        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();
        sixtht.start();
        seventh.start();
        eighth.start();
        ninth.start();
        tenth.start();
        eleventh.start();
        twelfth.start();
    }

    private static class Task implements Runnable {

        private String name;
        private CyclicBarrier barrier;

        public Task(String name, CyclicBarrier barrier) {

            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().interrupt();
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + " finished");
        }
    }
}
