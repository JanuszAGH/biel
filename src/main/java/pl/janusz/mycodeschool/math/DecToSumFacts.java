package pl.janusz.mycodeschool.math;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class DecToSumFacts {

    public static int convert(int number) {

        String num = "" + number;
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int n = Integer.parseInt("" + c);
            sum += fact(n);
        }
        return sum;
    }

    private static int fact(int n) {

        if (n < 2) {
            return n;
        }
        return n * (n - 1);
    }

    public static void main(String[] args) {

        int convert = convert(123);
        System.out.println(convert);
    }
}
