package pl.janusz.durga;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class ConcModExcList {

    public static void main(String[] args) throws InterruptedException {

        final ArrayList<String> list;
        list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService =
                Executors.newFixedThreadPool(nThreads);

        Callable<Void> modyfying = new Callable<Void>() {

            @Override
            public Void call() throws Exception {

                Thread.sleep(2);
//                list.remove(0);
//                list.remove(1);
//                list.remove(2);
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    list.add(String.valueOf(i + 10));
                    System.out.println(Thread.currentThread().getName() + " inserted " + (i + 10));
                    String remove = null;
                    try {
                        remove = list.remove(i);
                    } catch (Exception e) {
                        System.out.println("Catched");
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Removing " + i + " -> " + remove);
//                    System.out.println(Thread.currentThread().getName() + " inserted " + (i + 10));
                    Thread.sleep(777);
                }
                return null;
            }
        };

        executorService.submit(modyfying);

        System.out.println("Iterating started");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String format = String.format("%s: %s",
                    Thread.currentThread().getName(), next);
            System.out.println(format);
            Thread.sleep(1013);
        }
        System.out.println("Iterator finished");

        list.forEach(System.out::println);

        executorService.shutdown();
    }
}
