package pl.janusz.stones.pt02.ch02.hoselatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class House {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            final CountDownLatch latch = new CountDownLatch(1);
            final Fridge fridge = new Fridge();
            final Thread husband = new Thread(new Husband(fridge, latch));
            final Thread wife = new Thread(new Wife(fridge, latch));
            husband.start();
            wife.start();
            husband.join();
            wife.join();
            System.out.println(fridge.getBeer());
        }
    }
}
