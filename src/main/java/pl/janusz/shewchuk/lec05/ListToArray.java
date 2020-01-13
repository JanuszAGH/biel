package pl.janusz.shewchuk.lec05;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janusz Kacki on 07/01/2020. Project; bielmarcus
 */
public class ListToArray {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer[] ts = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(ts));
    }
}
