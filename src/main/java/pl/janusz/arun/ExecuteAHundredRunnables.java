package pl.janusz.arun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class ExecuteAHundredRunnables {

    public static void main(String[] args) {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        final int[] counter = new int[]{0};

        for (int i = 0; i < 16; i++) {
            executorService.execute(new Runnable() {

                @Override
                public void run() {

                    int c = ++counter[0];

                    System.out.println(
//                            String.format("%d: %s", ++counter[0], Thread.currentThread().getName()));
                            String.format("Starting %d", c));

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(
//                            String.format("%d: %s", c, Thread.currentThread().getName()));
                                    String.format("%d finished%n", counter[0]));
                }
            });
        }

        executorService.shutdown();
    }
}
