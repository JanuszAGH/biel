package pl.janusz.subramaniam.lambdas.pt01;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class FirstLambda {

    public static void main(String[] args) {

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        System.out.println(Thread.currentThread().getName());
    }
}
