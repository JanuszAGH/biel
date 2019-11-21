package pl.janusz.stones.pt01.ch03;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CounterSemaphore implements Counter {

    private BinarySemaphore semaphore = new BinarySemaphore();
    private int count;

    @Override
    public void inc() {

        semaphore.acquire();
        this.count++;
        semaphore.release();
    }

    @Override
    public void dec() {

        semaphore.acquire();
        this.count--;
        semaphore.release();
    }

    @Override
    public int get() {

        return this.count;
    }
}
