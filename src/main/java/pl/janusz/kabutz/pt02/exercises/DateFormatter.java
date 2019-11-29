package pl.janusz.kabutz.pt02.exercises;

import net.jcip.annotations.NotThreadSafe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
@NotThreadSafe
public class DateFormatter {

    private final ThreadLocal<DateFormat> dateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"))

    public String format(Date date) {

        return dateFormat.get().format(date);
    }

    public Date parse(String date) throws ParseException {

        return dateFormat.get().parse(date);
    }
}
