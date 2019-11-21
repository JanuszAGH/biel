package pl.janusz.stones.pt01.ch03;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CounterLockedOnObject implements Counter {

    private int count;

    private Object mutex = new Object();

    @Override
    public void inc() {

        synchronized (mutex) {
            count++;
        }
    }

    @Override
    public void dec() {

        synchronized (mutex) {
            count--;
        }
    }

    @Override
    public int get() {

        return count;
    }
}
