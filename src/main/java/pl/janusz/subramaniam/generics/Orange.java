package pl.janusz.subramaniam.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class Orange extends Fruit {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(null);
        integers.add(null);
        integers.add(2);

        integers.forEach(System.out::println);
    }
}
