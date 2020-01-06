package pl.janusz.techprimers.pt01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class FM {

    public static void main(String[] args) {

        Trip first = new Trip(Arrays.asList("Warszawa", "Krakow", "Gdańsk", "Sopot"));
        Trip second = new Trip(Arrays.asList("Zakopane", "Szczyrk", "Kudowa Zdrój"));
        Trip third = new Trip(Arrays.asList("Wieliczka", "Wadowice"));
        List<Trip> trips = Arrays.asList(first, second, third);

        Function<List<String>, Stream<String>> fm = new Function<List<String>, Stream<String>>() {

            @Override
            public Stream<String> apply(List<String> list) {

                return list.stream();
            }
        };

        trips.stream()
                .map(Trip::getCities)
                .flatMap(fm)
                .forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    private static class Trip {

        private List<String> cities;
    }
}
