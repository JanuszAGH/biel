package pl.janusz.techprimers.pt01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class M2Int {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(numbers.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }
}
