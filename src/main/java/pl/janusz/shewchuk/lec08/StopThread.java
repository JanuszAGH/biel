package pl.janusz.shewchuk.lec08;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 10/01/2020. Project; bielmarcus
 */
public class StopThread {

    private volatile static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
            Thread.dumpStack();
        }).start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
