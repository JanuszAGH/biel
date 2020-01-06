package pl.janusz.mycodeschool.math;

import java.util.Scanner;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class ExponentationLSD {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("base");
        int base = scanner.nextInt();
        System.out.println("exponent");
        int exponent = scanner.nextInt();

//        int power = power(base, exponent);
        double power = Math.pow(base, exponent);
        System.out.println(base);
        System.out.println(exponent);
        System.out.println(power);
        String text = "" + power;
        System.out.println(text.charAt(text.length() - 1));
    }

    private static int power(int base, int exponent) {

        int power = 1;
        for (int i = 0; i < exponent; i++) {
            power *= base;
        }
        return power;
    }
}
