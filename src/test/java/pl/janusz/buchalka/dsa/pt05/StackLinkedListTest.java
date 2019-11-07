package pl.janusz.buchalka.dsa.pt05;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class StackLinkedListTest extends StackTest {

    @Override
    protected Stack<String> getStack() {

        return new LinkedListStack<>();
    }
}
