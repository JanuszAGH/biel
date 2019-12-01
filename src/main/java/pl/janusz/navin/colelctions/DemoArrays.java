package pl.janusz.navin.colelctions;

import java.util.*;

/**
 * Created by Janusz Kacki on 30/11/2019. Project; bielmarcus
 */
public class DemoArrays {

    public static void main(String[] args) {

        Collection<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(5);
        integers.add(3);
        integers.add(7);

        List<Integer> list = new ArrayList<>();
        list.addAll(integers);

        System.out.println(list);
        list.sort(Integer::compareTo);
        System.out.println();
        System.out.println(list);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 != 0) {
                iterator.remove();
            }
        }

        System.out.println(numbers);
    }
}
