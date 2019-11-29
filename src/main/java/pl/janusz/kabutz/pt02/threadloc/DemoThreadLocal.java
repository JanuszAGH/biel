package pl.janusz.kabutz.pt02.threadloc;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class DemoThreadLocal {

    public static void main(String[] args) {

        new DemoThreadLocal().start();
    }

    private void start() {

        Thread thread1 = new Thread(new DemoRunnable());
        Thread thread2 = new Thread(new DemoRunnable());
        thread1.start();
        thread2.start();
    }

    private class DemoRunnable implements Runnable {

        Integer random = ThreadLocalRandom.current().nextInt(1000);
        private ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

        @Override
        public void run() {

            integerThreadLocal.set(random);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " " + integerThreadLocal.get());
        }
    }
}
