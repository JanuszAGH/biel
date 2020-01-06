package pl.janusz.durga;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class Children {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Void> callable = new Callable<Void>() {

            @Override
            public Void call() throws Exception {

                System.out.println(Thread.currentThread().getName() + " will sleep");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " woke up");
                return null;
            }
        };

        executorService.invokeAll(Arrays.asList(callable,callable, callable, callable));

        executorService.shutdown();
    }
}
