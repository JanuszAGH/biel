package pl.janusz.buchalka.dsa.pt08;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class SearcherTestImplBinary extends SearcherTest {

    @Override
    protected Searcher getSearcher() {

        return new SearcherBinary();
    }
}
