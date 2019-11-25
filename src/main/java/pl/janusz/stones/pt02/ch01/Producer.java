package pl.janusz.stones.pt02.ch01;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class Producer implements Callable<Void> {

    private Drop drop;

    public Producer(Drop drop) {

        this.drop = drop;
    }

    @Override
    public Void call() throws Exception {

        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            drop.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        drop.put("DONE");

        return null;
    }
}
