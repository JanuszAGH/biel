package pl.janusz.kabutz.pt01.sugar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janusz Kacki on 28/11/2019. Project; bielmarcus
 */
public class AsRunnableLambda {

    public static void main(String[] args) {

        new AsRunnableLambda().start();
    }

    private void start() {

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.submit(() -> System.out.println("Job in lambda " + this.getClass().getName()));
        executorService.submit(new Runnable() {

            @Override
            public void run() {

                System.out.println("Job in  inner " + this.getClass().getName());
            }
        });

        executorService.shutdown();
    }
}
