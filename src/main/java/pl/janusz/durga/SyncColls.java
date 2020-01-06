package pl.janusz.durga;

import java.util.*;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class SyncColls {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);

        Set<Integer> set = new HashSet<>();
        Set<Integer> synchronizedSet = Collections.synchronizedSet(set);

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);

        System.out.println(map.putIfAbsent("A", 1));
        System.out.println(map.putIfAbsent("A", 2));
        System.out.println(map.putIfAbsent("A", 3));
        System.out.println(map.putIfAbsent("A", 4));
        System.out.println(map.putIfAbsent("A", 5));
        System.out.println(map.putIfAbsent("A", 6));
        System.out.println(map.putIfAbsent("A", 7));
        System.out.println(map.remove("A"));
    }
}
