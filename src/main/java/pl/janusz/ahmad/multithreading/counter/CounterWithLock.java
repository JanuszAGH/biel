package pl.janusz.ahmad.multithreading.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class CounterWithLock implements Counter {

    private int count;
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {

        lock.lock();
        try {
            this.count++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void decrement() {

        lock.lock();
        try {
            this.count--;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getCount() {

        return this.count;
    }
}
