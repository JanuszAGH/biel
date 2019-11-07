package pl.janusz.buchalka.dsa.pt07.jdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class RemoveDuplicatesChallenge {

    public static void removeDuplicates(List<?> list) {

        Set<Object> set = new HashSet<>();

        final Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            if (set.contains(next)) {
                iterator.remove();
            } else {
                set.add(next);
            }
        }
    }
}
