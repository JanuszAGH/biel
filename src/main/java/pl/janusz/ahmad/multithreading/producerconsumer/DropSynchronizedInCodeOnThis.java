package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class DropSynchronizedInCodeOnThis implements Drop {

    private String message = null;
    private boolean isEmpty = true;

    @Override
    public void put(String message) {

        synchronized (this) {
            while (!isEmpty) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.message = message;
            isEmpty = false;
            this.notifyAll();
        }
    }

    @Override
    public String take() {

        synchronized (this) {
            while (isEmpty) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isEmpty = true;
            this.notifyAll();

            return this.message;
        }
    }
}
