package pl.janusz.durga;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class ConcMap {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        System.out.println(map.put(101, "A"));
        System.out.println(map.putIfAbsent(102, "B"));
        System.out.println(map.putIfAbsent(101, "X"));
        System.out.println(map.putIfAbsent(101, "X"));
        
    }
}
