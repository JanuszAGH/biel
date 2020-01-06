package pl.janusz.techprimers.pt01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class ExamplePerson {

    public static void main(String[] args) {

        System.out.println(getPeople().stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.toList()
                        )
                ));
    }

    private static List<Person> getPeople() {

        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    private enum Gender {MALE, FEMALE;}

    @Data
    @AllArgsConstructor
    private static class Person {

        private String name;
        private Gender gender;
        private int age;
    }
}
