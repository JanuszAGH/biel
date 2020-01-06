package pl.janusz.zooce;

import com.sun.scenario.effect.Merge;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class SortersTestImplMerge extends SortersTest {

    @Override
    protected Sorters obtainSorter() {

        return new MergeSort();
    }
}
