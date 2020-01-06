package pl.janusz.durga;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janusz Kacki on 04/12/2019. Project; bielmarcus
 */
public class ConcModExcMapDurgaExecutorNoExc {

    public static void main(String[] args) {

        Map<Integer, String> map;
        map = new ConcurrentHashMap<>();
//        map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        Runnable modify = () -> {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(7, "Lucky");
        };

        Runnable iterate = () -> {
            Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Iterate finished");
        };
        new Thread(iterate).start();
        new Thread(modify).start();
    }
}
