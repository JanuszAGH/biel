package pl.janusz.in28minutes.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@ThreadSafe
public class BinarySemaphore implements Semaphore {

    public static final int MAX_SLOTS = 1;
    @GuardedBy("this")
    private int free = 1;

    @Override
    public synchronized void acquire() {

        while (free == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        free--;
    }

    @Override
    public synchronized void release() {

        while (free == MAX_SLOTS) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        free++;
        notifyAll();
    }
}
