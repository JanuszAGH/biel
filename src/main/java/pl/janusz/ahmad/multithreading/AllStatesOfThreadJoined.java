package pl.janusz.ahmad.multithreading;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class AllStatesOfThreadJoined {

    private static Thread thread1;
    private static Thread thread2;

    public static void main(String[] args) throws InterruptedException {

        thread1 = new Thread(new RunnableTask1());
        thread2 = new Thread(new RunnableTask2());

        String format1 = String.format("%s %s", thread1.getName(), thread1.getState());
        String format2 = String.format("%s %s", thread2.getName(), thread2.getState());

        System.out.println(format1);
        System.out.println(format2);



        format2 = String.format("%s %s", thread2.getName(), thread2.getState());
        format1 = String.format("%s %s", thread1.getName(), thread1.getState());
        System.out.println(format1);
        System.out.println(format2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        format2 = String.format("%s %s", thread2.getName(), thread2.getState());
        format1 = String.format("%s %s", thread1.getName(), thread1.getState());
        System.out.println(format1);
        System.out.println(format2);
    }

    private static class RunnableTask1 implements Runnable {

        @Override
        public void run() {

            String format = String.format("%s %s", Thread.currentThread().getName(), Thread.currentThread().getState());
            System.out.println(format);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String formatOuter = String.format("%s %s", Thread.currentThread().getName(), thread2.getState());
            System.out.println(formatOuter);
        }
    }

    private static class RunnableTask2 implements Runnable {

        @Override
        public void run() {

            String format = String.format("%s %s", Thread.currentThread().getName(), Thread.currentThread().getState());
            System.out.println(format);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
