package pl.janusz.buchalka.dsa.pt09;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public abstract class BSTTest {

    protected BST<Integer> tree;
    protected Integer[] numbers;

    @Before
    public void setUp() throws Exception {

        tree = getTree();

        numbers = new Integer[]{10, 5, 15, 3, 7, 8, 17};
    }

    protected abstract BST getTree();

    @Test
    public void emptyAtTheBeginning() {

        assertThat(tree.contains(1), is(false));
    }

    @Test
    public void oneElementTreeDoesNotContainOtherElements() {

        tree.insert(7);
        assertThat(tree.contains(-3), is(false));
        assertThat(tree.contains(-1), is(false));
        assertThat(tree.contains(0), is(false));
        assertThat(tree.contains(1), is(false));
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(3), is(false));
        assertThat(tree.contains(4), is(false));
        assertThat(tree.contains(5), is(false));
        assertThat(tree.contains(6), is(false));
        assertThat(tree.contains(13), is(false));
    }

    @Test
    public void insertOneElement() {

        tree.insert(5);
        final boolean contains = tree.contains(5);
        assertThat(contains, is(true));
    }

    @Test
    public void insertTwoElementsSecondToLeft() {

        tree.insert(5);
        tree.insert(3);
        boolean contains;
        contains = tree.contains(5);
        assertThat(contains, is(true));
        contains = tree.contains(3);
        assertThat(contains, is(true));
    }

    @Test
    public void insertTwoElementsSecondToRight() {

        tree.insert(5);
        tree.insert(7);
        boolean contains;
        contains = tree.contains(7);
        assertThat(contains, is(true));
        contains = tree.contains(5);
        assertThat(contains, is(true));
    }

    @Test
    public void insertMany() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        for (Integer number : numbers) {
            assertThat(tree.contains(number), is(true));
        }
    }

    @Test
    public void insertManyNotContainsOthet() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        for (Integer number : numbers) {
            assertThat(tree.contains(number + 20), is(false));
        }
    }

    @Test
    public void minOfEmptyTreeIsNull() {

        assertThat(tree.min(), is(nullValue()));
    }

    @Test
    public void minOfOneElementTree() {

        tree.insert(7);
        assertThat(tree.min(), is(7));
    }

    @Test
    public void minOfThreeElementsTree() {

        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        assertThat(tree.min(), is(3));
    }

    @Test
    public void maxOfEmptyTreeIsNull() {

        assertThat(tree.max(), is(nullValue()));
    }

    @Test
    public void maxOfOneElementTree() {

        tree.insert(7);
        assertThat(tree.max(), is(7));
    }

    @Test
    public void maxOfThreeElementsTree() {

        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        assertThat(tree.max(), is(9));
    }

    @Test
    public void minInMany() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        assertThat(tree.min(), is(3));
    }

    @Test
    public void maxInMany() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        assertThat(tree.max(), is(17));
    }

    @Test
    public void deleteFromEmptyTree() {

        assertThat(tree.contains(1), is(false));
        tree.delete(1);
        assertThat(tree.contains(1), is(false));
    }

    @Test
    public void deleteFromOneElementTree() {

        tree.insert(1);
        assertThat(tree.contains(1), is(true));
        tree.delete(1);
        assertThat(tree.contains(1), is(false));
    }

    @Test
    public void deleteParentFromTwoElementsTreeChildonleft() {

        tree.insert(2);
        tree.insert(1);
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(2), is(true));
        tree.delete(2);
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(1), is(true));
    }

    @Test
    public void deleteParentFromTwoElementsTreeChildOnRight() {

        tree.insert(2);
        tree.insert(3);
        assertThat(tree.contains(3), is(true));
        assertThat(tree.contains(2), is(true));
        tree.delete(2);
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(3), is(true));
    }

    @Test
    public void deleteParentFromThreeElementsTreeChildOnRightAndLeft() {

        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        assertThat(tree.contains(3), is(true));
        assertThat(tree.contains(2), is(true));
        assertThat(tree.contains(1), is(true));
        tree.delete(2);
        assertThat(tree.contains(2), is(false));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(3), is(true));
    }

    @Test
    public void deleteLeftChildFromThreeElementsTreeChildOnRightAndLeft() {

        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        assertThat(tree.contains(3), is(true));
        assertThat(tree.contains(2), is(true));
        assertThat(tree.contains(1), is(true));
        tree.delete(1);
        assertThat(tree.contains(1), is(false));
        assertThat(tree.contains(2), is(true));
        assertThat(tree.contains(3), is(true));
    }

    @Test
    public void deleteRigftChildFromThreeElementsTreeChildOnRight() {

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);
        tree.insert(12);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(10), is(true));
        assertThat(tree.contains(12), is(true));
        tree.delete(10);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(12), is(true));
    }

    @Test
    public void deleteRigftChildFromThreeElementsTreeChildOnLeft() {

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);
        tree.insert(7);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(10), is(true));
        assertThat(tree.contains(7), is(true));
        tree.delete(10);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(7), is(true));
    }

    @Test
    public void deleteRigftChildFromThreeElementsTreeChildOnLeftAndRight() {

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(10), is(true));
        assertThat(tree.contains(7), is(true));
        assertThat(tree.contains(12), is(true));
        tree.delete(10);
        assertThat(tree.contains(5), is(true));
        assertThat(tree.contains(1), is(true));
        assertThat(tree.contains(7), is(true));
        assertThat(tree.contains(12), is(true));
    }

    @Test
    public void deleteAllNumbersFromBiggerTree() {

        for (Integer number : numbers) {
            tree.insert(number);
        }

        for (Integer number : numbers) {
            assertThat(tree.contains(number), is(true));
        }

        for (Integer number : numbers) {
            tree.delete(number);
            assertThat(tree.contains(number), is(false));
        }
    }

    @Test
    public void manyInsertionsAndDeletionssSimulteneously() {

        List<Integer> aHundred = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            aHundred.add(i + 1);
        }

        Collections.shuffle(aHundred);
        List<Integer> added = new ArrayList<>();
        List<Integer> removed = new ArrayList<>();
        added.addAll(aHundred);
        Collections.shuffle(aHundred);
        removed.addAll(aHundred);

        Iterator<Integer> addedIterator;
        Iterator<Integer> removedIterator;

        for (int i = 0; i < 10; i++) {
            addedIterator = added.iterator();
            removedIterator = removed.iterator();

            while (addedIterator.hasNext()) {
                final Integer next = addedIterator.next();
                if (next % 3 == 0) {
                    tree.insert(next);
                    tree.insert(next);
                    tree.delete(next + 100);
                    tree.delete(next - 100);
                    addedIterator.remove();
                    isbBST(tree);
                    assertThat(tree.isBST(), is(true));
                }
            }

            while (removedIterator.hasNext()) {
                final Integer next = removedIterator.next();
                if (next % 6 == 0) {
                    tree.delete(next);
                    tree.delete(next + 100);
                    tree.delete(next - 100);
                    tree.delete(next);
                    removedIterator.remove();
                    isbBST(tree);
                    assertThat(tree.isBST(), is(true));
                }
            }
        }

        for (Integer integer : added) {
            tree.insert(integer);
            tree.insert(integer);
            isbBST(tree);
            assertThat(tree.isBST(), is(true));
        }

        for (Integer integer : removed) {
            tree.delete(integer);
            tree.delete(integer);
            isbBST(tree);
            assertThat(tree.isBST(), is(true));
        }
        isbBST(tree);
    }

    @Test
    public void iterateThroughOneElementTree() {

        tree.insert(1);
        final Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            assertThat(next, is(1));
        }
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void iterateThroughTwoElementTreeLeftChild() {

        tree.insert(2);
        tree.insert(1);
        final Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        Integer next;
        next = iterator.next();
        assertThat(next, is(1));
        next = iterator.next();
        assertThat(next, is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void iterateThroughTwoElementTreeRightChild() {

        tree.insert(2);
        tree.insert(3);
        final Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        Integer next;
        next = iterator.next();
        assertThat(next, is(2));
        next = iterator.next();
        assertThat(next, is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void iterateThroughThreeelementTreeLeftRightChild() {

        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        final Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        Integer next;
        next = iterator.next();
        assertThat(next, is(1));
        next = iterator.next();
        assertThat(next, is(2));
        next = iterator.next();
        assertThat(next, is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void addThreeDeleteThreeIsBST() {

        isbBST(tree);
        tree.insert(2);
        isbBST(tree);
        tree.insert(3);
        isbBST(tree);
        tree.insert(1);
        isbBST(tree);
        tree.delete(2);
        isbBST(tree);
        tree.delete(1);
        isbBST(tree);
        tree.delete(3);
        isbBST(tree);
    }

    @Test
    public void emptyTreeIteratesNoElements() {

        final Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void biggerTreeIsBST() {

        for (Integer number : numbers) {
            tree.insert(number);
            isbBST(tree);
        }
    }

    private void isbBST(BST<Integer> tree) {

        final Iterator<Integer> iterator = tree.iterator();
        Integer prev = null;
        Integer next = null;
        if (iterator.hasNext()) {
            prev = iterator.next();
        }
        while (iterator.hasNext()) {
            next = iterator.next();
            assertThat(next, greaterThan(prev));
            prev = next;
        }
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void isBSTNumbersTree() {

        for (Integer number : numbers) {
            tree.insert(number);
            assertThat(tree.isBST(), is(true));
        }
    }

    @Test
    public void bstAndTreeSet() {

        final TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < 1000; i++) {
            final int anInt = ThreadLocalRandom.current().nextInt(50);
            tree.insert(anInt);
            treeSet.add(anInt);
        }

        while (!treeSet.isEmpty()) {
            final Integer min = tree.min();
            assertThat(tree.contains(min), is(true));
            tree.delete(min);
            assertThat(tree.contains(min), is(false));
            treeSet.remove(min);
        }
    }
}

