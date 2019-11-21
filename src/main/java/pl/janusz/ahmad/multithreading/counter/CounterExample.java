package pl.janusz.ahmad.multithreading.counter;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class CounterExample {

    public static void main(String[] args) throws InterruptedException {

        Counter counter;
        counter = new CounterUnsynchronized();
        counter = new CounterWithLock();
        counter = new CounterSynchronized();
        counter = new CounterSynchronizedSemaphore();


        final Thread inc = new Thread(new Incrementer(counter));
        final Thread dec = new Thread(new Decrementer(counter));

        inc.start();
        dec.start();

        inc.join();
        dec.join();
        System.out.println(counter.getCount());
    }
}
