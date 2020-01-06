package pl.janusz.durga;

import java.util.*;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class FailFast {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 5) {
                list.remove(4);
            }
            System.out.println(next);
        }

        Iterator<Map.Entry<Integer, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, String> next = entryIterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
            if (next.getKey() == 3) {
                map.put(7, "7");
            }
        }
    }
}
