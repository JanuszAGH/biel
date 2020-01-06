package pl.janusz.mycodeschool.math;

import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public final class DecimalToBinary {

    private DecimalToBinary() {

    }

    public static final String convert(int number) {

        if (number == 0) {
            return "0";
        }

        LinkedList<String> digits = new LinkedList<>();

        int reminder;

        while (number > 0) {
            reminder = number % 2;
            number = number / 2;
            digits.push(String.valueOf(reminder));
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!digits.isEmpty()) {
            stringBuilder.append(digits.pop());
        }

        return stringBuilder.toString();
    }
}
