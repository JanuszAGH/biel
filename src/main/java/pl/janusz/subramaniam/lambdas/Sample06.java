package pl.janusz.subramaniam.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample06 {

    public static void main(String[] args) {

        BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {

            @Override
            public Integer apply(Integer a, Integer e) {

                return a + e;
            }
        };

        Predicate<Integer> isEven = new Predicate<Integer>() {

            @Override
            public boolean test(Integer e) {

                return e % 2 == 0;
            }
        };
        Function<Integer, Integer> doubleValue = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer e) {

                return 2 * e;
            }
        };

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = numbers.stream()
                .filter(isEven)
                .map(doubleValue)
                .mapToInt(e -> e)
                .sum();
        System.out.println(reduce);
    }
}
