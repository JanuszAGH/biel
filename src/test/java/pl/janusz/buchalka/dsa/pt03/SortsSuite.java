package pl.janusz.buchalka.dsa.pt03;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ShellSortTest.class,
        SelectionSortTest.class,
        QuickSortTest.class,
        MergeSortTest.class,
        MergeSortReverseTest.class,
        JDKSortTest.class,
        JDKParallelSortTest.class,
        InsertionSortTest.class,
        InsertionSortRecursiveTest.class,
        CountingSortTest.class,
        BubbleSortTest.class,
        BucketSort.class
})
public class SortsSuite {

}
