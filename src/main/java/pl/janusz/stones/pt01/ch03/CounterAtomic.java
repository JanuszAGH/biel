package pl.janusz.stones.pt01.ch03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CounterAtomic implements Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void inc() {

        atomicInteger.incrementAndGet();
    }

    @Override
    public void dec() {

        atomicInteger.decrementAndGet();
    }

    @Override
    public int get() {

        return atomicInteger.get();
    }
}
