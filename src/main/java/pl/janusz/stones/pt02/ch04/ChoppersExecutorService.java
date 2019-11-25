package pl.janusz.stones.pt02.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class ChoppersExecutorService {

    public static void main(String[] args) {

        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        final ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        for (int i = 0; i < availableProcessors * 4; i++) {
            executorService.submit(new Thread(new Chopper()));
        }

        executorService.shutdown();
    }
}
