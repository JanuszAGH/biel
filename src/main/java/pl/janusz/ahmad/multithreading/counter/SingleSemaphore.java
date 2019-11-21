package pl.janusz.ahmad.multithreading.counter;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class SingleSemaphore {

    private int acquiredSoFar;
    private int maxCapacity;

    public SingleSemaphore(int maxCapacity) {

        this.maxCapacity = maxCapacity;
        this.acquiredSoFar = 0;
    }

    public SingleSemaphore() {

        this(Integer.MAX_VALUE);
    }

    public synchronized void acquire() {

        while (acquiredSoFar == maxCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        acquiredSoFar++;
    }

    public synchronized void release() {

        while (acquiredSoFar == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        acquiredSoFar--;
        notifyAll();
    }
}
