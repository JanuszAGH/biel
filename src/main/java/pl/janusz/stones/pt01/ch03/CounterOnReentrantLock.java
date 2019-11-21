package pl.janusz.stones.pt01.ch03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CounterOnReentrantLock implements Counter {

    private int count;
    private Lock lock = new ReentrantLock();

    @Override
    public void inc() {

        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void dec() {

        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int get() {

        return count;
    }
}
