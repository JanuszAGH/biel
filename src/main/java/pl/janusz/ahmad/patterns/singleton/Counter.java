package pl.janusz.ahmad.patterns.singleton;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class Counter {

    private static Counter INSTANCE = null;

    private int count;

    private Counter() {

    }

    public static Counter getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new Counter();
        }

        return INSTANCE;
    }

    public void inc() {

        this.count++;
    }

    public void dec() {

        this.count--;
    }

    public int getCount() {

        return this.count;
    }
}
