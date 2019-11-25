package pl.janusz.stones.pt01.ch03;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CounterExample {

    public static void main(String[] args) throws InterruptedException {

        final ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Counter counter;
        counter = new CounterAtomic();
        counter = new CounterSemaphore();
        counter = new CounterLockedOnObject();
        counter = new CounterOnReentrantLock();
        counter = new CounterReadWriteLock();
        counter = new CounterNestedFunctions();


        final Incrementer incrementer = new Incrementer(counter);
        final Decrementer decrementer = new Decrementer(counter);
        Collection<Callable<Void>> callables = Arrays.asList(
                incrementer, decrementer,
                decrementer, incrementer,
                decrementer, decrementer,
                incrementer, incrementer,
                incrementer, decrementer,
                decrementer, incrementer,
                decrementer, incrementer);

        final List<Future<Void>> futures = executorService.invokeAll(callables);

        System.out.println(counter.get());

        executorService.shutdown();
    }
}
