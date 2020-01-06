package pl.janusz.durga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class FailSafe {

    public static void main(String[] args) {

//        Map<String, Integer> map = new ConcurrentHashMap<>();
//
//        map.put("First", 10);
//        map.put("Second", 20);
//        map.put("Third", 30);
//        map.put("Fourth", 40);
//
//        Iterator<String> iterator = map.keySet().iterator();
//
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            map.put("Fifth", 50);
//            System.out.println(key);
//        }

        List<Integer> cowal = new CopyOnWriteArrayList<>();
        cowal.add(1);
        cowal.add(3);
        cowal.add(5);
        cowal.add(7);

        Iterator<Integer> it = cowal.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next == 1) {
                cowal.add(2);
                cowal.add(4);
                cowal.add(6);
//                cowal.remove(0);
//                cowal.remove(1);
//                cowal.remove(2);
//                cowal.remove(3);
//                it.remove();
            }                   
            System.out.println(next);
        }
        System.out.println();
        System.out.println(cowal);

    }                   
}
