package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class BinarySemaphore {

    private boolean isOpen = true;

    public BinarySemaphore(boolean isOpen) {

        this.isOpen = isOpen;
    }

    public BinarySemaphore() {

        this(true);
    }

    public synchronized void acquire() {

        while (!isOpen) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isOpen = false;
    }

    public synchronized void release() {

        while (isOpen) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isOpen = true;
        notifyAll();
    }
}
