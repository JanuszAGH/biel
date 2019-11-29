package pl.janusz.kabutz.pt02.cntr;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
@ThreadSafe
public final class Counter {

    //    INVARIANT: value>=0
    @GuardedBy("this")
    private long value = 0L;

    public synchronized long getValue() {

        return value;
    }

    //    POST-CONDITION: new.value == odl.value +1
    public synchronized long increment() {

        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("overflow");
        }

        long oldValue = value;
        long result = ++value;

        assert result == oldValue + 1 : "Post-condition fail";

        return result;
    }
}
