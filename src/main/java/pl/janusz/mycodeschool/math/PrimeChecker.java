package pl.janusz.mycodeschool.math;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class PrimeChecker {

    public static boolean check(int number) {

        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i < number - 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
