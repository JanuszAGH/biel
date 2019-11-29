package pl.janusz.kabutz.pt01;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */

import net.jcip.annotations.NotThreadSafe;

/**
 * TODO: Annotate this class
 * The class should be annotated aither @ThreadSafe, @NotThreadSafe
 * or the @Immutable tag
 */
@NotThreadSafe
public class Person2 {

    private final String firstName;
    private final String surname;
    private int age;

    public Person2(String firstName, String surname, int age) {

        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public void birtday() {

        age += 1;
    }
}
