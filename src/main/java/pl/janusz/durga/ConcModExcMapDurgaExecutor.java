package pl.janusz.durga;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class ConcModExcMapDurgaExecutor {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();

        Runnable runnable = () -> {
            map.put(7, "Lucky");
        };

        executorService.submit(runnable);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        executorService.shutdown();
    }
}
