package pl.janusz.navin.colelctions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 30/11/2019. Project; bielmarcus
 */
@State(Scope.Benchmark)
public class VectorLinkedListArrayListBenchmark {

    private Vector<Integer> vector;
    private List<Integer> arrayList;
    private List<Integer> linkedList;

    @Param({"1000000"})
    private int size;

    @Setup
    public void setUp() throws Exception {

        vector = new Vector<>();
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            int rand = ThreadLocalRandom.current().nextInt();
            vector.add(rand);
            arrayList.add(rand);
            linkedList.add(rand);
        }
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureVector(Blackhole blackhole) {

        for (int i = 0; i < size; i++) {
            vector.add(vector.size() / 2, i);
        }

        blackhole.consume(vector);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureArrayList(Blackhole blackhole) {

        for (int i = 0; i < size; i++) {
            arrayList.add(vector.size() / 2, i);
        }

        blackhole.consume(arrayList);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureLinkedList(Blackhole blackhole) {

        for (int i = 0; i < size; i++) {
            linkedList.add(vector.size() / 2, i);
        }

        blackhole.consume(linkedList);
    }
}