package pl.janusz.subramaniam.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample01 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        long start = System.nanoTime();
        int sum = numbers
                .stream()
//                .parallel()
                .filter(e -> e % 2 == 0)
                .mapToInt(Sample01::heavyComputations)
                .map(e -> 2 * 2)
                .sum();
        long end = System.nanoTime();
        long duration = (end - start) / 1_000_000;
        System.out.println(duration);
    }

    public static Integer heavyComputations(Integer e) {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        return e;
    }
}
