package pl.janusz.stones.pt01.ch02;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 20/11/2019. Project; bielmarcus
 */
public class MainThread {

    public static void main(String[] args) {

        final Thread cook = new Thread(new Runnable() {

            @Override
            public void run() {

                final Thread cleaner = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        while (true) {
                            System.out.println("Cleaning...");
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                });

                cleaner.setDaemon(true);
                cleaner.start();
                
                System.out.println("Cooking...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Dishes are ready");
            }
        });

        cook.start();
    }
}
