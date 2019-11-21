package pl.janusz.stones.pt01.ch03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class BinarySemaphore {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private boolean acquired;

    public void acquire() {

        lock.lock();
        try {
            while (acquired) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            acquired = true;
        } finally {
            lock.unlock();
        }
    }

    public void release() {

        lock.lock();
        try {
            acquired = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
