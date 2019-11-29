package pl.janusz.kabutz.pt01;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * TODO: Annotate this class
 * The class should be annotated aither @ThreadSafe, @NotThreadSafe
 * or the @Immutable tag
 */
@ThreadSafe
public class Person3 {

    private final String firstName;
    private final String surname;
    @GuardedBy("this")
    private volatile int age;

    public Person3(String firstName, String surname, int age) {

        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public synchronized void birtday() {

        age += 1;
    }

    public int getAge() {

        return age;
    }
}
