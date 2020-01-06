package pl.janusz.mycodeschool.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class PrimeFactorizer {

    public static List<Integer> getPrimeFactors(int n) {

        List<Integer> factors = new ArrayList<>();

//        factors.add(1);

        int number = n;
        for (int i = 2; i < n; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }

        if (factors.isEmpty()) {
            factors.add(n);
        }

        Collections.sort(factors);

        return factors;
    }

    public static void main(String[] args) {

        List<List<Integer>> factorsList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
//            System.out.println(i + " : " + getPrimeFactors(i));
            factorsList.add(getPrimeFactors(i));
        }
        factorsList.forEach(System.out::println);
    }
}
