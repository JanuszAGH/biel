package pl.janusz.subramaniam.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class Sample01 {

    public static void main(String[] args) {

        List<? super Object> list=new ArrayList<>();
        list.add(1);
        Object o = list.get(0);
        System.out.println(o);
    }
}
