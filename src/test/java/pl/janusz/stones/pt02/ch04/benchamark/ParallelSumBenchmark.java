package pl.janusz.stones.pt02.ch04.benchamark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
@State(Scope.Benchmark)
public class ParallelSumBenchmark {

    public static final int SIZE = 1_000_000;

    @Param({"100", "1000", "10000", "100000"})
    int threshold;

    private Integer[] array = new Integer[SIZE];
    private ForkJoinPool forkJoinPool;

    @Setup
    public void setup() {

        forkJoinPool = ForkJoinPool.commonPool();
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1 + 1;
        }
    }

    @TearDown
    public void tearDown() {

        forkJoinPool.shutdown();
    }

    @Warmup(iterations = 0)
    @Fork(1)
    @Benchmark
    public void measureParallelSum(Blackhole blackhole) {

        final Long result = forkJoinPool.invoke(new Sum(array, 0, SIZE, threshold));

        blackhole.consume(result);
    }
}
