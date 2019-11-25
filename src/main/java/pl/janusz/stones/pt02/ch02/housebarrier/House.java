package pl.janusz.stones.pt02.ch02.housebarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class House {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            final CyclicBarrier barrier = new CyclicBarrier(2);
            final Fridge fridge = new Fridge();
            final Thread husband = new Thread(new Husband(fridge, barrier));
            final Thread wife = new Thread(new Wife(fridge, barrier));
            husband.start();
            wife.start();
            husband.join();
            wife.join();
            System.out.println(fridge.getBeer());
        }
    }
}
