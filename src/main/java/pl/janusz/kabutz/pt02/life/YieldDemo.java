package pl.janusz.kabutz.pt02.life;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class YieldDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        Thread.yield();
                        System.out.println(Thread.currentThread().getName());
                    }
                }
        );

        thread.start();

        for (int i = 0; i < 5; i++) {
//            Thread.yield();
            System.out.println(Thread.currentThread().getName());
        }
    }
}

