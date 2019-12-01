package pl.janusz.navin.colelctions;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Janusz Kacki on 30/11/2019. Project; bielmarcus
 */
public class DemoVectors {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>(2);
        System.out.println(vector.capacity());
        vector.add(1);
        vector.add(2);
        System.out.println(vector.capacity());
        vector.add(3);
        vector.add(4);
        System.out.println(vector.capacity());
        vector.add(5);
        System.out.println(vector.capacity());

        Vector<Object> objects = new Vector<>();
        System.out.println(objects.capacity());

        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println();
        vector.forEach(System.out::println);
    }
}
