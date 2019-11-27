package pl.janusz.purcell.pt12;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public class CountingSemaphore implements Semaphore {

    private static final int DEFAULT_SIZE = 1;
    private int currentCount;
    private int maxCount;

    public CountingSemaphore(int size) {

        this.maxCount = size;
        this.currentCount=size;
    }

    public CountingSemaphore() {

        this(DEFAULT_SIZE);
    }

    @Override
    public synchronized void acquire() {

        while (currentCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        currentCount--;
    }

    @Override
    public synchronized void release() {

        while (currentCount == maxCount) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        currentCount++;
        notifyAll();
    }

    @Override
    public void setAvailableSlots(int slots) {

        this.currentCount = slots;
    }
}
