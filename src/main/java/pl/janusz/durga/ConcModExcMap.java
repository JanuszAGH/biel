package pl.janusz.durga;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class ConcModExcMap {

    public static void main(String[] args) throws InterruptedException {

        final Map<Integer, String> map;
//        map = new ConcurrentHashMap<>();
        map = new HashMap<>();

        Callable<Void> modyfying = new Callable<Void>() {

            @Override
            public Void call() {

                for (int i = 0; i < 10; i++) {
                    map.put(i + 10, "val " + i);
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(3));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };

        map.putIfAbsent(1, "a");
        map.putIfAbsent(2, "b");
        map.putIfAbsent(3, "c");

        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        executorService.submit(modyfying);
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            String format = String.format("%s: %d - %s",
                    Thread.currentThread().getName(), next.getKey(), next.getValue());
            System.out.println(format);
            try {
                Thread.sleep(1013);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        Thread.sleep(5000);
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
