package pl.janusz.ahmad.multithreading.producerconsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class DropSynchronizedOnLock implements Drop {

    private String message = null;
    private boolean isEmpty = true;
    private Lock lock = new ReentrantLock();

    @Override
    public void put(String message) {

        synchronized (lock) {
            while (!isEmpty) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.message = message;
            isEmpty = false;
            lock.notifyAll();
        }
    }

    @Override
    public String take() {

        synchronized (lock) {
            while (isEmpty) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isEmpty = true;
            lock.notifyAll();

            return this.message;
        }
    }
}
