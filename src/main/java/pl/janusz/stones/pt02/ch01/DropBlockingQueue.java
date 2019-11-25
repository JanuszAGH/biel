package pl.janusz.stones.pt02.ch01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class DropBlockingQueue implements Drop {

    private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

    @Override
    public void put(String message) {

        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String take() {

        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

         return null;
    }
}
