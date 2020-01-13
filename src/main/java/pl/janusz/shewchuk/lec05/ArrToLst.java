package pl.janusz.shewchuk.lec05;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janusz Kacki on 07/01/2020. Project; bielmarcus
 */
public class ArrToLst {

    public static void main(String[] args) {

        Integer[] integers = {1, 2, 3};
        List<Integer> list = Arrays.asList(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println(list);
    }
}
