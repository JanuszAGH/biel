package pl.janusz.durga;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class ConcModExcListDurgaExecutor {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        Runnable runnable = () -> {
            list.add(7);
        };

        executorService.submit(runnable);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        executorService.shutdown();
    }
}
