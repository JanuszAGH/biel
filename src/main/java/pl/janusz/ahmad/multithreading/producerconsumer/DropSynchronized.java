package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class DropSynchronized implements Drop {

    private String message;
    private boolean isEmpty = true;

    @Override
    public synchronized void put(String message) {

        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        isEmpty = false;
        notifyAll();
    }

    @Override
    public synchronized String take() {

        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isEmpty = true;
        notifyAll();

        return this.message;
    }
}
