package pl.janusz.buchalka.dsa.pt05.benchmarks;

import org.junit.Test;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Deque;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@State(Scope.Thread)
public abstract class DequeBenchmarks {

    @Param({"100", "1000"})
    private int elements;

    private Deque<Integer> deque;

    @Setup
    public void setup() {

        deque = getDeque();
    }

    protected abstract Deque getDeque();

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureDeque(Blackhole blackhole) {

        for (int i = 0; i < elements; i++) {
            deque.push(i);
        }

        blackhole.consume(deque);
    }
}