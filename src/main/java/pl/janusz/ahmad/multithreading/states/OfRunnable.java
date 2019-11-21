package pl.janusz.ahmad.multithreading.states;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class OfRunnable {

    public static void main(String[] args) {

        String format = String.format("%s %s", Thread.currentThread().getName(), Thread.currentThread().getState());
        System.out.println(format);
        new Thread(new FromRunnable()).start();
        format = String.format("%s %s", Thread.currentThread().getName(), Thread.currentThread().getState());
        System.out.println(format);
        new Thread(new FromRunnable()).start();
        format = String.format("%s %s", Thread.currentThread().getName(), Thread.currentThread().getState());
        System.out.println(format);
        new Thread(new FromRunnable()).start();
        format = String.format("%s %s", Thread.currentThread().getName(), Thread.currentThread().getState());
        System.out.println(format);
    }

    private static class FromRunnable implements Runnable {

        @Override
        public void run() {

            final String format = String.format("%s", Thread.currentThread().getName());
            System.out.println(format);
        }
    }
}
