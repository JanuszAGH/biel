package pl.janusz.ba.ch03;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public class LinkedListTest extends ListTestBase {

    @Override
    protected List<String> createList() {

        return new LinkedList<>();
    }
}
