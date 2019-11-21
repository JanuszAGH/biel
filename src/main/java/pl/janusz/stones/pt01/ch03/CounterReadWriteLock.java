package pl.janusz.stones.pt01.ch03;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CounterReadWriteLock implements Counter {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private int counter;

    @Override
    public void inc() {

        readWriteLock.writeLock().lock();
        try {
            counter++;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void dec() {

        readWriteLock.writeLock().lock();
        try {
            counter--;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public int get() {

        readWriteLock.readLock().lock();
        try {
            return counter;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
