package pl.janusz.kabutz.pt02.threadloc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class DFTLDemo {

    public static void main(String[] args) {

        new DFTLDemo().start();
    }

    private void start() {

        new Thread(new DemoRunnable()).start();
        new Thread(new DemoRunnable()).start();
        new Thread(new DemoRunnable()).start();
        new Thread(new DemoRunnable()).start();
    }

    private class DemoRunnable implements Runnable {

        private ThreadLocal<SimpleDateFormat> dateFormatTL = new ThreadLocal<>();

        @Override
        public void run() {
            dateFormatTL.set(new SimpleDateFormat("yyyy/MM/dd"));

            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = dateFormatTL.get();
            String format = simpleDateFormat.format(date);
            System.out.println(Thread.currentThread().getName() + " " + format);
        }
    }
}
