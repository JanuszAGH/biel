package pl.janusz.stones.pt02.ch01;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class ProducerConsumer {

    public static void main(String[] args) {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Drop drop;
        drop = new DropBlockingQueue();
        drop = new DropBinarySemaphore();

        final Producer producer = new Producer(drop);
        final Consumer consumer = new Consumer(drop);

        final List<Callable<Void>> callables = Arrays.asList(producer, consumer);

        try {
            final List<Future<Void>> futures = executorService.invokeAll(callables);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executorService.shutdown();
    }
}
