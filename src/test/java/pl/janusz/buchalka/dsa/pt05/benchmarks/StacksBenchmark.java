package pl.janusz.buchalka.dsa.pt05.benchmarks;

import org.junit.Test;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@State(Scope.Thread)
public class StacksBenchmark {

    @Param({"100000", "10000000"})
    private int elements;

    private Stack<Integer> stack;
    private LinkedList<Integer> stackLinkedList;

    @Setup
    public void setup() {

        stack = new Stack<>();
        stackLinkedList = new LinkedList<>();
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureStack(Blackhole blackhole) {

        for (int i = 0; i < elements; i++) {
            stack.push(i);
        }
        blackhole.consume(stack);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureStackLinkedList(Blackhole blackhole) {

        for (int i = 0; i < elements; i++) {
            stackLinkedList.push(i);
        }
        blackhole.consume(stackLinkedList);
    }
}