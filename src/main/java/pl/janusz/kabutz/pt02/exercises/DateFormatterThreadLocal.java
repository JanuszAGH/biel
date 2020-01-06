package pl.janusz.kabutz.pt02.exercises;

import net.jcip.annotations.ThreadSafe;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
@ThreadSafe
public class DateFormatterThreadLocal {

    private final ThreadLocal<DateFormat> dateFormat;

    public DateFormatterThreadLocal() {

        this.dateFormat = new ThreadLocal<>();
        dateFormat.set(new SimpleDateFormat("yyyy-MM-dd"));
    }

    public String format(Date date) {

        return dateFormat.get().format(date);
    }

    public Date parse(String date) throws ParseException {

        return dateFormat.get().parse(date);
    }
}
