package pl.janusz.subramaniam.lambdas.pt01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class Samp01 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer<Integer> consumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {

                System.out.println(integer);
            }
        };

        numbers
                .forEach(consumer);

        System.out.println();
        
        for (Integer number : numbers) {
            consumer.accept(number);
        }
    }
}
