package pl.janusz.buchalka.dsa.pt06;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class QueueTestImplArray extends QueueTest {

    @Override
    protected Queue<String> getQueue() {

        return new ArrayQueue<>();
    }
}
