package pl.janusz.in28minutes.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class Cowal {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Ant");
        list.add("Bat");
        list.add("Cat");
    }
}
