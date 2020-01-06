package pl.janusz.in28minutes.concurrent;

import net.jcip.annotations.NotThreadSafe;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@NotThreadSafe
public class CounterNTS implements Counter {

    private int i;

    @Override
    public int getI() {

        return i;
    }

    @Override
    public void decrement() {

        i--;
    }

    @Override
    public void increment() {

        i++;
    }
}
