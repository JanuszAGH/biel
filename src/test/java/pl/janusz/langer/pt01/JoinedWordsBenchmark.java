package pl.janusz.langer.pt01;

import org.junit.Test;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
@State(Scope.Benchmark)
public class    JoinedWordsBenchmark {

    @Param({"100", "1000"})
    int repetitions;

    private List<String> words;

    @Setup
    public void setup() {

        words = new ArrayList<>();
        String[] wordsArray = new String[]{
                "Alice", "in", "Wonderland", "the", "Cat", "Alice", "in", "Wonderland", "the", "Cat"};

        for (int i = 0; i < repetitions; i++) {
            for (String word : wordsArray) {
                words.add(word);
            }
        }
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureReduction(Blackhole blackhole) {

        String reduce = words.stream()
                .parallel()
                .reduce("", (a, e) -> a + e);
        blackhole.consume(reduce);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureCollect(Blackhole blackhole) {

        String collect = words.stream()
                .parallel()
                .collect(Collectors.joining(""));
        blackhole.consume(collect);
    }
}