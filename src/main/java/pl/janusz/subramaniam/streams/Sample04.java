package pl.janusz.subramaniam.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample04 {

    private static List<Person> people;

    public static void main(String[] args) {

        Map<Gender, Long> collect = getPeople()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + " " + v));
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

    private static enum Gender {MALE, FEMALE;}

    @Data
    @AllArgsConstructor
    private static class Person {

        private String name;
        private Gender gender;
        private int age;
    }
}
