package pl.janusz.in28minutes.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@ThreadSafe
public class CounterSemaphore implements Counter {

    private final Semaphore semaphore = new BinarySemaphore();
    @GuardedBy("semaphore")
    private int i;

    @Override
    public int getI() {

        semaphore.acquire();
        int i = this.i;
        semaphore.release();
        return i;
    }

    @Override
    public void decrement() {

        semaphore.acquire();
        i--;
        semaphore.release();
    }

    @Override
    public void increment() {

        semaphore.acquire();
        i++;
        semaphore.release();
    }
}
