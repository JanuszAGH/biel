package pl.janusz.buchalka.dsa.pt10;

/**
 * Created by Janusz Kacki on 07/11/2019. Project; bielmarcus
 */
public class HeapTestImplMaxHeap extends HeapTest {

    @Override
    protected Heap<Integer> getHeap() {

        return new HeapMax<>();
    }
}
