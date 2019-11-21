package pl.janusz.ahmad.multithreading.counter;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class CounterSynchronized implements Counter {

    private int count;

    @Override
    public synchronized void increment() {

        this.count++;
    }

    @Override
    public synchronized void decrement() {

        this.count--;
    }

    @Override
    public int getCount() {

        return this.count;
    }
}
