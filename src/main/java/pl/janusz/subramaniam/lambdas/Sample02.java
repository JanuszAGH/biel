package pl.janusz.subramaniam.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample02 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = numbers.stream()
                .reduce(Integer::sum);
        Integer integer = reduce.orElse(0);
        System.out.println(integer);

        numbers.stream()
                .map(String::valueOf)
                .forEach(System.out::println);

        int a = 7;
        String s1 = Integer.toString(a);
        String s2 = String.valueOf(a);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1.getClass().getName());
        System.out.println(s2.getClass().getName());
    }
}
