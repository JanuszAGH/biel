package pl.janusz.in28minutes.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@ThreadSafe
public class CounterLock implements Counter {

    private final Lock lock = new ReentrantLock();

    @GuardedBy("lock")
    private int i;

    @Override
    public int getI() {

        lock.lock();
        try {
            return i;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void decrement() {

        lock.lock();
        try {
            i--;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void increment() {

        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }
}
