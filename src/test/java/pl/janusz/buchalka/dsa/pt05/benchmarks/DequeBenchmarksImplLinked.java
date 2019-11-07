package pl.janusz.buchalka.dsa.pt05.benchmarks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class DequeBenchmarksImplLinked extends DequeBenchmarks {

    @Override
    protected Deque getDeque() {

        return new LinkedList<>();
    }
}
