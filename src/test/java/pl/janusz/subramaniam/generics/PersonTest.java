package pl.janusz.subramaniam.generics;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class PersonTest {

    private String john;
    private String doe;
    private int age;

    @Test
    public void personBuildGetSet() {                               

        String adam = "Adam";
        String brown = "Brown";
        int age = 22;
        Person person = new Person.PersonBuilder().firstName(adam).surname(brown).age(age).build();
        assertThat(person, hasProperty("firstName", equalTo(adam)));
        assertThat(person, hasProperty("surname", equalTo(brown)));
        assertThat(person, hasProperty("age", equalTo(age)));
    }

    @Test
    public void personBuilder() {

        john = "John";
        doe = "Doe";
        age = 21;
        Person johnDoe = new Person(john, doe, age);
        Person person = new Person.PersonBuilder().firstName(john).surname(doe).age(age).build();

        assertThat(person, samePropertyValuesAs(johnDoe));
    }
}