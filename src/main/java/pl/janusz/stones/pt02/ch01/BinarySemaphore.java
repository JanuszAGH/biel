package pl.janusz.stones.pt02.ch01;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class BinarySemaphore {

    private boolean open;

    public BinarySemaphore(boolean open) {

        this.open = open;
    }

    public synchronized void acquire() {

        while (!open) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        open = false;
    }

    public synchronized void release() {

        while (open) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        open = true;

        notifyAll();
    }
}
