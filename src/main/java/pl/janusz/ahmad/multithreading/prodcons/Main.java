package pl.janusz.ahmad.multithreading.prodcons;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public class Main {

    public static void main(String[] args) {

        final Basket basket = new Basket();
        new Thread(new Consumer(basket) ).start();
        new Thread(new Producer(basket) ).start();
    }
}
