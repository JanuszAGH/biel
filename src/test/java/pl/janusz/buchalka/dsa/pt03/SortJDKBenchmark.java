package pl.janusz.buchalka.dsa.pt03;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Janusz Kacki on 25/10/2019. Project; bielmarcus
 */
@State(Scope.Thread)
public class SortJDKBenchmark {

    @Param({"100", "1000", "10000", "100000", "1000000"})
    private int arraySize;

    private Integer[] array;

    @Setup
    public void setup() {

        array = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {                          
            array[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void singleThread(Blackhole blackhole) {

        JDKSort.sort(array);
        blackhole.consume(array);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void parallel(Blackhole blackhole) {

        JDKParallelSort.sort(array);
        blackhole.consume(array);
    }
}
