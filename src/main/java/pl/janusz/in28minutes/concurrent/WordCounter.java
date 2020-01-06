package pl.janusz.in28minutes.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class WordCounter {

    public ConcurrentMap<Character, Integer> countCharacters(String text) {

        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        return map;
    }
}
