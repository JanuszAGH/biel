package pl.janusz.zooce;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class SortersTestImplSelection extends SortersTest {

    @Override
    protected Sorters obtainSorter() {

        return new SelectionSort();
    }
}
