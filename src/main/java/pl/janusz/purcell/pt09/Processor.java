package pl.janusz.purcell.pt09;


import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 26/11/2019. Project; bielmarcus
 */
public class Processor {

    private static final int LIMIT = 10;

    private LinkedList<Integer> list = new LinkedList<>();

    public void produce() {

        int value = 0;
        while (true) {
            list.add(value);
        }
    }

    public void consume() {

        while (true) {
            final Integer value = list.removeFirst();
        }
    }
}
