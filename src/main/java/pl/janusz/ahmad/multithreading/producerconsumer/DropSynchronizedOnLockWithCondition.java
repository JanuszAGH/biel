package pl.janusz.ahmad.multithreading.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class DropSynchronizedOnLockWithCondition implements Drop {

    private String message = null;
    private boolean isEmpty = true;
    private Lock lock = new ReentrantLock();
    private Condition inDoor = lock.newCondition();
    private Condition outDoor = lock.newCondition();

    @Override
    public void put(String message) {

        lock.lock();
        try {
            while (!isEmpty) {
                try {
                    inDoor.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.message = message;
            outDoor.signalAll();
            isEmpty = false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String take() {

        lock.lock();
        try {
            while (isEmpty) {
                try {
                    outDoor.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isEmpty = true;
            inDoor.signalAll();

            return this.message;
        } finally {
            lock.unlock();
        }
    }
}
