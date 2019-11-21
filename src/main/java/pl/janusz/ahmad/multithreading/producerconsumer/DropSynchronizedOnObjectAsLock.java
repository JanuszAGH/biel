package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class DropSynchronizedOnObjectAsLock implements Drop {

    private String message = null;
    private boolean isEmpty = true;
    private Object lock = new Object();

    @Override
    public void put(String message) {

        synchronized (lock) {
            while ((!isEmpty)) {
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
    public synchronized String take() {

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
