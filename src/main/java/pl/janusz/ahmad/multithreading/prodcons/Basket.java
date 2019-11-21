package pl.janusz.ahmad.multithreading.prodcons;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class Basket {

    private boolean isEmpty = true;

    private String element;

    public synchronized void put(String element) {

        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.element = element;
        isEmpty = false;
        notifyAll();
    }

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
        
        return element;
    }
}
