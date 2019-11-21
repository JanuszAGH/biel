package pl.janusz.ahmad.multithreading.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class CounterUnsynchronized implements Counter {

    private int count;

    @Override
    public void increment() {

        this.count++;
    }

    @Override
    public void decrement() {

        this.count--;
    }

    @Override
    public int getCount() {

        return this.count;
    }
}
