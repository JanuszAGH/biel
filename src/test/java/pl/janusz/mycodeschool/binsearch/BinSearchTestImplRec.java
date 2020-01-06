package pl.janusz.mycodeschool.binsearch;

/**
 * Created by Janusz Kacki on 13/12/2019. Project; bielmarcus
 */
public class BinSearchTestImplRec extends BinSearchTest {

    @Override
    protected BinSearch getBinSearch() {

        return new BinSearchImplRec();
    }
}
