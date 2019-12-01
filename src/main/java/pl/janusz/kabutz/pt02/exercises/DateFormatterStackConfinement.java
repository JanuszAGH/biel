package pl.janusz.kabutz.pt02.exercises;

import net.jcip.annotations.ThreadSafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
@ThreadSafe
public class DateFormatterStackConfinement {

    public String format(Date date) {

        return createSimpleDateFormat().format(date);
    }

    private SimpleDateFormat createSimpleDateFormat() {

        return new SimpleDateFormat("yyyy-MM-dd");
    }

    public Date parse(String date) throws ParseException {

        return createSimpleDateFormat().parse(date);
    }
}
