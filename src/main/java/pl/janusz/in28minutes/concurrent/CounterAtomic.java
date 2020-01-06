package pl.janusz.in28minutes.concurrent;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@ThreadSafe
public class CounterAtomic implements Counter {

    private AtomicInteger i = new AtomicInteger();

    @Override
    public int getI() {

        return i.get();
    }

    @Override
    public void decrement() {

        i.decrementAndGet();
    }

    @Override
    public void increment() {

        i.incrementAndGet();
    }
}
