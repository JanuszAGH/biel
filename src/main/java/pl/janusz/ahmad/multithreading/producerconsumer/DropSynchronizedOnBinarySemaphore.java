package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class DropSynchronizedOnBinarySemaphore implements Drop {

    private BinarySemaphore inputSemaphore = new BinarySemaphore(true);
    private BinarySemaphore outputSemaphore = new BinarySemaphore(false);
    private volatile String message;

    @Override
    public void put(String message) {

        inputSemaphore.acquire();
        this.message = message;
        outputSemaphore.release();
    }

    @Override
    public String take() {

        outputSemaphore.acquire();
        String result = null;
        result = this.message;
        inputSemaphore.release();

        return result;
    }
}
