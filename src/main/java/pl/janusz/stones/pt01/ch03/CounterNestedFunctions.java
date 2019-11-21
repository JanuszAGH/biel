package pl.janusz.stones.pt01.ch03;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class CounterNestedFunctions implements Counter {

    private int count;

    @Override
    public void inc() {

        int val = readVal();
        val = modifyInPlusVal(val);
        writeVal(val);
    }

    private int modifyInPlusVal(int val) {

        return ++val;
    }

    private int readVal() {

        return count;
    }

    @Override
    public void dec() {

        int val = readVal();
        val = modifyInMinusVal(val);
        writeVal(val);
    }

    private void writeVal(int val) {

        count = val;
    }

    private int modifyInMinusVal(int val) {

        return --val;
    }

    @Override
    public int get() {

        return 0;
    }
}
