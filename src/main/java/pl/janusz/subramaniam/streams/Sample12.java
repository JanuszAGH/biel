package pl.janusz.subramaniam.streams;

import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample12 {

    public static void main(String[] args) {

        System.out.println(compute(51, 121));
    }

    public static int compute(int n, int k) {

        return Stream.iterate(k, e -> e + 1)
                .filter(e -> Math.sqrt(e) > 20)
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> 2 * e)
                .limit(n)
                .sum();
    }
}
