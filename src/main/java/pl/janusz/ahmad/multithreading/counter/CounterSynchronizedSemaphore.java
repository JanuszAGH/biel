package pl.janusz.ahmad.multithreading.counter;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class CounterSynchronizedSemaphore implements Counter {

    private SingleSemaphore semaphore = new SingleSemaphore(1);
    private int count;

    @Override
    public void increment() {

        semaphore.acquire();
        try {
            this.count++;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void decrement() {

        semaphore.acquire();
        try {
            this.count--;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public int getCount() {

        return this.count;
    }
}
