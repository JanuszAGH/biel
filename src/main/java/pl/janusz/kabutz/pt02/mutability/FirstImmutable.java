package pl.janusz.kabutz.pt02.mutability;

import net.jcip.annotations.Immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
@Immutable
public class FirstImmutable {

    private final List<String> namesList = new ArrayList<>();

    public FirstImmutable(String... name) {

        namesList.addAll(Arrays.asList(name));
    }

    public List<String> getNamesList() {

        return Collections.unmodifiableList(namesList);
    }
}
