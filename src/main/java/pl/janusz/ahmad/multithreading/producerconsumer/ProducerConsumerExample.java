package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class ProducerConsumerExample {

    public static void main(String[] args) {

        Drop drop;
        drop = new DropUnSynchronized();
        drop = new DropSynchronized();
        drop = new DropSynchronizedInCodeOnThis();
        drop = new DropSynchronizedOnObjectAsLock();
        drop = new DropSynchronizedOnLock();
        drop = new DropSynchronizedOnLockWithCondition();
        drop = new DropSynchronizedOnBinarySemaphore();

        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
