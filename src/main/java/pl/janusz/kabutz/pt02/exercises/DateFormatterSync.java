package pl.janusz.kabutz.pt02.exercises;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
@ThreadSafe
public class DateFormatterSync {

    @GuardedBy("this")
    private final DateFormat dateFormat;

    public DateFormatterSync() {

        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public synchronized String format(Date date) {

        return dateFormat.format(date);
    }

    public synchronized Date parse(String date) throws ParseException {

        return dateFormat.parse(date);
    }
}
