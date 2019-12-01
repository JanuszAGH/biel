package pl.janusz.subramaniam.generics;

import java.util.HashSet;

/**
 * Created by Janusz Kacki on 30/11/2019. Project; bielmarcus
 */
public class DemoSet {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
    }
}
