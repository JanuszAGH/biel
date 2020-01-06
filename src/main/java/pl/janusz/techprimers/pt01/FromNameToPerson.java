package pl.janusz.techprimers.pt01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class FromNameToPerson {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Adam", "Becky", "Jill");

        System.out.println(names.stream()
                .map(Person::new)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.toCollection(ArrayList::new)
                )));
    }

    @Data
    @AllArgsConstructor
    private static class Person {

        private String name;

        @Override
        public String toString() {

            return this.name;
        }
    }
}
