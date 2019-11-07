package pl.janusz.ba.ch03;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public abstract class ListTestBase {

    protected String a;
    protected String b;
    protected String c;
    protected List<String> list = createList();
    private Iterator<String> iterator;

    @Test
    public void emptyListAtTheBeginning() {

        assertThat(list.isEmpty(), is(true));
        assertThat(list.size(), is(0));
    }

    @Test
    public void addOneElement() {

        list.add(a);
        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(1));

        assertThat(list.get(0), is(equalTo(a)));
    }

    @Test
    public void addToEmptyListOtPositionZero() {

        list.add(0, a);
        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(1));

        assertThat(list.get(0), is(a));
    }

    @Test
    public void addTwoElements() {

        list.add(a);
        list.add(b);

        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(2));

        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(b));
    }

    @Test
    public void addTwoElementsSpecyfyingindices() {

        list.add(0, a);
        list.add(0, b);

        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(2));

        assertThat(list.get(0), is(b));
        assertThat(list.get(1), is(a));
    }

    @Test
    public void addThreeElements() {

        list.add(a);
        list.add(b);
        list.add(c);

        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(3));

        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(b));
        assertThat(list.get(2), is(c));
    }

    @Test
    public void addThreeElementsSpecyfyingIndices() {

        list.add(0, a);
        list.add(0, b);
        list.add(0, c);

        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(3));

        assertThat(list.get(0), is(c));
        assertThat(list.get(1), is(b));
        assertThat(list.get(2), is(a));
    }

    @Test
    public void addThreeElementsSpecyfyingIndicesInOrder() {

        list.add(0, a);
        list.add(1, b);
        list.add(2, c);

        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(3));

        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(b));
        assertThat(list.get(2), is(c));
    }

    @Test
    public void insertBeforeFirstElement() {

        list.add(a);
        list.add(0, b);
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(b));
        assertThat(list.get(1), is(a));
    }

    @Test
    public void insertAfterelement() {

        list.add(a);
        list.add(1, b);
        list.add(c);
        assertThat(list.size(), is(3));
        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(b));
        assertThat(list.get(2), is(c));
    }

    @Test
    public void insertOutOfBound() {

        try {
            list.add(1, a);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }

        try {
            list.add(-1, a);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }

    @Test
    public void getOutOfBond() {

        try {
            list.get(0);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }

        try {
            list.get(-1);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }

    @Test
    public void setOutOfBond() {

        try {
            list.set(0, a);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }

        try {
            list.set(-1, a);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }

    @Test
    public void setValueToEmptyListThrowException() {

        try {
            list.set(0, a);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }

    @Test
    public void setValueToOneElementList() {

        list.add(a);
        final Object set = list.set(0, b);
        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(1));
        assertThat(set, is(equalTo(a)));
        assertThat(list.get(0), is(equalTo(b)));
    }

    @Test
    public void setValueToThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);
        Object set;
        set = list.set(0, b);
        assertThat(set, is(equalTo(a)));
        set = list.set(1, c);
        assertThat(set, is(equalTo(b)));
        set = list.set(2, a);
        assertThat(set, is(equalTo(c)));
        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(3));

        assertThat(list.get(0), is(equalTo(b)));
        assertThat(list.get(1), is(equalTo(c)));
        assertThat(list.get(2), is(equalTo(a)));
    }

    @Test
    public void removeOutOfBondThrowsException() {

        try {
            list.remove(0);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
        try {
            list.remove(-1);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(IndexOutOfBoundsException.class));
        }
    }

    @Test
    public void removeFromOneElementList() {

        list.add(a);
        final String remove = list.remove(0);
        assertThat(list.size(), is(0));
        assertThat(list.isEmpty(), is(true));
        assertThat(remove, is(equalTo(a)));
    }

    @Test
    public void removeFirstFromThreeElementsList() {

        list.add(a);
        list.add(b);
        list.add(c);
        final String remove = list.remove(0);
        assertThat(list.size(), is(2));
        assertThat(remove, is(equalTo(a)));
    }

    @Test
    public void removeSecondFromThreeElementsList() {

        list.add(a);
        list.add(b);
        list.add(c);
        final String remove = list.remove(1);
        assertThat(list.size(), is(2));
        assertThat(remove, is(equalTo(b)));
    }

    @Test
    public void removeThirdFromThreeElementsList() {

        list.add(a);
        list.add(b);
        list.add(c);
        final String remove = list.remove(2);
        assertThat(list.size(), is(2));
        assertThat(remove, is(equalTo(c)));
    }

    @Test
    public void removeAllForwardFromThreeElementsList() {

        list.add(a);
        list.add(b);
        list.add(c);
        String remove;
        remove = list.remove(0);
        assertThat(list.size(), is(2));
        assertThat(remove, is(equalTo(a)));
        remove = list.remove(0);
        assertThat(list.size(), is(1));
        assertThat(remove, is(equalTo(b)));
        remove = list.remove(0);
        assertThat(list.size(), is(0));
        assertThat(remove, is(equalTo(c)));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void removeAllBackwardFromThreeElementsList() {

        list.add(a);
        list.add(b);
        list.add(c);
        String remove;
        remove = list.remove(list.size() - 1);
        assertThat(list.size(), is(2));
        assertThat(remove, is(equalTo(c)));
        remove = list.remove(list.size() - 1);
        assertThat(list.size(), is(1));
        assertThat(remove, is(equalTo(b)));
        remove = list.remove(list.size() - 1);
        assertThat(list.size(), is(0));
        assertThat(remove, is(equalTo(a)));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void removeByValueFromOneElementList() {

        list.add(a);
        final boolean remove = list.remove(a);
        assertThat(list.isEmpty(), is(true));
        assertThat(remove, is(true));
    }

    @Test
    public void removeFirstByValueFromThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);

        final boolean remove = list.remove(a);
        assertThat(remove, is(true));
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(b));
        assertThat(list.get(1), is(c));
    }

    @Test
    public void removeSecondByValueFromThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);

        final boolean remove = list.remove(b);
        assertThat(remove, is(true));
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(c));
    }

    @Test
    public void removeThirdByValueFromThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);

        final boolean remove = list.remove(c);
        assertThat(remove, is(true));
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(b));
    }

    @Test
    public void removeaAllReverseOrderByValueFromThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);

        boolean remove;
        remove = list.remove(c);
        assertThat(remove, is(true));
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(b));
        remove = list.remove(b);
        assertThat(remove, is(true));
        assertThat(list.size(), is(1));
        assertThat(list.get(0), is(a));
        remove = list.remove(a);
        assertThat(remove, is(true));
        assertThat(list.size(), is(0));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void removeaAllInOrderByValueFromThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);

        boolean remove;
        remove = list.remove(a);
        assertThat(remove, is(true));
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(b));
        assertThat(list.get(1), is(c));
        remove = list.remove(b);
        assertThat(remove, is(true));
        assertThat(list.size(), is(1));
        assertThat(list.get(0), is(c));
        remove = list.remove(c);
        assertThat(remove, is(true));
        assertThat(list.size(), is(0));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void indexInOneElementList() {

        list.add(a);
        final int i = list.indexOf(a);
        assertThat(i, is(0));
    }

    @Test
    public void indexInThreeOfNonExistingElementList() {

        list.add(a);
        list.add(b);
        list.add(a);
        final int i = list.indexOf(c);
        assertThat(i, is(-1));
    }

    @Test
    public void indexInThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);
        int i;
        i = list.indexOf(a);
        assertThat(i, is(0));
        i = list.indexOf(b);
        assertThat(i, is(1));
        i = list.indexOf(c);
        assertThat(i, is(2));
    }

    @Test
    public void indexInOneOfNonExistingElementList() {

        list.add(a);
        final int i = list.indexOf(b);
        assertThat(i, is(-1));
    }

    @Before
    public void setUp() throws Exception {

        a = new String("A");
        b = new String("B");
        c = new String("C");

        List<String> list = createList();
        iterator = this.list.iterator();
    }

    protected abstract List<String> createList();

    @Test
    public void iteratorHasNonextOnEmptyList() {

        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void iteratorOnOneElementHasOneNext() {

        list.add(a);
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void iteratorOnThreeElementHasOneNext() {

        list.add(a);
        list.add(b);
        list.add(c);
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void getByIteratorInOneElementList() {

        list.add(a);
        final String next = iterator.next();
        assertThat(next, is(a));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void getByIteratorInThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);
        String next;
        next = iterator.next();
        assertThat(next, is(a));
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        assertThat(next, is(b));
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        assertThat(next, is(c));
        assertThat(iterator.hasNext(), is(false));

        assertThat(list.get(0), is(a));
        assertThat(list.get(1), is(b));
        assertThat(list.get(2), is(c));
    }

    @Test
    public void iteratorRemoveFromOneElementList() {

        list.add(a);
        final String next = iterator.next();
        assertThat(next, is(a));
        assertThat(list.get(0), is(a));
        iterator.remove();
        assertThat(list.size(), is(0));
    }

    @Test
    public void removeFromTwoElementList() {

        list.add(a);
        list.add(b);
        String next;
        assertThat(list.size(), is(2));
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        assertThat(next, is(a));
        iterator.remove();
        assertThat(list.size(), is(1));
        assertThat(iterator.hasNext(), is(true));
        next = iterator.next();
        assertThat(next, is(b));
        assertThat(iterator.hasNext(), is(false));
        assertThat(list.size(), is(1));
    }

    @Test
    public void removeByIteratorInThreeElementList() {

        list.add(a);
        list.add(b);
        list.add(c);
        String next;
        next = iterator.next();
        assertThat(next, is(a));
        assertThat(iterator.hasNext(), is(true));
        iterator.remove();
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(b));
        assertThat(list.get(1), is(c));

        next = iterator.next();
        assertThat(next, is(b));
        assertThat(iterator.hasNext(), is(true));
        iterator.remove();
        assertThat(list.size(), is(1));
        assertThat(list.get(0), is(c));

        next = iterator.next();
        assertThat(next, is(c));
        assertThat(iterator.hasNext(), is(false));
        iterator.remove();
        assertThat(list.size(), is(0));
    }

    @Test
    public void clearShouldCleanList() {

        list.add(a);
        list.add(b);
        list.add(c);

        list.clear();
        assertThat(list.isEmpty(), is(true));
    }
}