package pl.janusz.kabutz.pt02.cntr;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public final class Counter {

    @GuardedBy("this")
    private long value = 0L;

    public synchronized long getValue() {

        return value;
    }

    public synchronized long increment() {

        return ++value;
    }
}
