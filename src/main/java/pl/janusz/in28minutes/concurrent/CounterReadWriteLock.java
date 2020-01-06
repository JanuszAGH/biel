package pl.janusz.in28minutes.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@ThreadSafe
public class CounterReadWriteLock implements Counter {

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    @GuardedBy("lock")
    private int i;

    @Override
    public int getI() {

        lock.readLock().lock();
        try {
            return i;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void decrement() {

        lock.writeLock().lock();
        try {
            i--;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void increment() {

        lock.writeLock().lock();
        try {
            i++;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
