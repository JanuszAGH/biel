package pl.janusz.ahmad.multithreading;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class AllStatesOfThread {

    public static void main(String[] args) throws InterruptedException {

        final Thread thread = new Thread(new RunnableTask());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        TimeUnit.SECONDS.sleep(2);
        System.out.println(thread.getState());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(thread.getState());
    }

    private static class RunnableTask implements Runnable {

        @Override
        public void run() {

            String format = String.format("%s %s", Thread.currentThread().getName(), Thread.currentThread().getState());
            System.out.println(format);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
