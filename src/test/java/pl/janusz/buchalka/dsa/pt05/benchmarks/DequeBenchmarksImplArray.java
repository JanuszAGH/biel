package pl.janusz.buchalka.dsa.pt05.benchmarks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class DequeBenchmarksImplArray extends DequeBenchmarks {

    @Override
    protected Deque getDeque() {

        return new ArrayDeque<>(16);
    }
}
