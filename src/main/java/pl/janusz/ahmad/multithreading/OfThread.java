package pl.janusz.ahmad.multithreading;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class OfThread {

    public static void main(String[] args) {

        String format = String.format("%s", Thread.currentThread().getName());
        System.out.println(format);
        new FromThread().start();
        format = String.format("%s", Thread.currentThread().getName());
        System.out.println(format);
        new FromThread().start();
        format = String.format("%s", Thread.currentThread().getName());
        System.out.println(format);
        new FromThread().start();
        format = String.format("%s", Thread.currentThread().getName());
        System.out.println(format);
    }

    private static class FromThread extends Thread {

        @Override
        public void run() {

            final String format = String.format("%s", Thread.currentThread().getName());
            System.out.println(format);
        }
    }
}
