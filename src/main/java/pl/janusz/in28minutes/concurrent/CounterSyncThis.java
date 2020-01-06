package pl.janusz.in28minutes.concurrent;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@ThreadSafe
public class CounterSyncThis implements Counter {

    @GuardedBy("this")
    private int i;

    @Override
    public synchronized int getI() {

        return i;
    }

    @Override
    public synchronized void decrement() {

        i--;
    }

    @Override
    public synchronized void increment() {

        i++;
    }
}
