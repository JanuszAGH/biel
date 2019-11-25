package pl.janusz.stones.pt02.ch01;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class DropBinarySemaphore implements Drop {

    private String message;
    private BinarySemaphore semaphoreInput = new BinarySemaphore(true);
    private BinarySemaphore semaphoreOutput = new BinarySemaphore(false);

    @Override
    public void put(String message) {

        semaphoreInput.acquire();
        this.message = message;
        semaphoreOutput.release();
    }

    @Override
    public String take() {

        semaphoreOutput.acquire();
        final String message = this.message;
        semaphoreInput.release();

        return message;
    }
}
