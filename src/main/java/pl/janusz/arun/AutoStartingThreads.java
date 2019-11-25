package pl.janusz.arun;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class AutoStartingThreads {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Task(new TaskRunanble());
        }
    }

    private static class Task extends Thread {

        public Task(Runnable target) {

            super(target);
            this.start();                 
        }
    }

    private static class TaskRunanble implements Runnable {

        private static final int LIMIT = 5;

        @Override
        public void run() {

            for (int i = 0; i < LIMIT; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                final String format = String.format("%s executed %d times", Thread.currentThread().getName(), i);
                System.out.println(format);
            }
        }
    }
}
