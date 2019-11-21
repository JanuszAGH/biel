package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class DropUnSynchronized implements Drop {

    private String message = null;
    private boolean isEmpty = true;

    @Override
    public void put(String message) {

        if (isEmpty) {
            this.message = message;
            isEmpty = false;
        }
    }

    @Override
    public String take() {

        if (!isEmpty) {
            isEmpty = true;
            return this.message;
        }

        return null;
    }
}
