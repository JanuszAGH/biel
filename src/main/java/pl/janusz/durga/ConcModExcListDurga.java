package pl.janusz.durga;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class ConcModExcListDurga {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        new Thread(() -> {
            list.add(7);
        }).start();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
