package pl.janusz.subramaniam.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample08 {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        int i = numbers
                .stream()
                .filter(e -> e % 2 == 0)
                .filter(e -> e > 3)
                .mapToInt(e -> 2 * e)
                .findFirst()
                .orElse(Integer.MAX_VALUE);

        System.out.println(i);

        int result = Integer.MAX_VALUE;
        int index = 0;
        while (index < numbers.size() && !(numbers.get(index) % 2 == 0 && numbers.get(index) > 3)) {
            index++;
        }

        if (index < numbers.size()) {
            result = numbers.get(index);
            result *= 2;
        }

        System.out.println(result);
    }
}
