package pl.janusz.subramaniam.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
public class Sample06 {

    private static List<Person> people;

    public static void main(String[] args) {

        Map<String, List<Person>> listedByNames = getPeople()
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.toList()));

        Map<String, Long> countedByName = getPeople()
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        List<String> allNames = getPeople()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        Map<String, Long> countedByNames = allNames
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Gender, List<String>> namesByGender = getPeople()
                .stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.mapping(Person::getName, Collectors.toList())
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