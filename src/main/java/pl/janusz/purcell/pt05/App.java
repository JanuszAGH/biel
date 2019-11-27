package pl.janusz.purcell.pt05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janusz Kacki on 25/11/2019. Project; bielmarcus
 */
public class App {

    public static void main(String[] args) {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Processor(i + 1));
        }
        System.out.println("All started");

        executorService.shutdown();

        System.out.println("Shutting down");
    }
}
