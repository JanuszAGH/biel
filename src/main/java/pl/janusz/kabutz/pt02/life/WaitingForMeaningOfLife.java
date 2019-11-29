package pl.janusz.kabutz.pt02.life;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class WaitingForMeaningOfLife {

    private volatile static boolean ready;
    private volatile static int number;

    public static void main(String[] args) throws InterruptedException {

        new ReaderThread().start();

        TimeUnit.SECONDS.sleep(1);
        ready = true;
        number = 44;
    }

    private static class ReaderThread extends Thread {

        @Override
        public void run() {

            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }
}
