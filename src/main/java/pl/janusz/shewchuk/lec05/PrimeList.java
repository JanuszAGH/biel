package pl.janusz.shewchuk.lec05;

import java.util.Scanner;

/**
 * Created by Janusz Kacki on 07/01/2020. Project; bielmarcus
 */
public class PrimeList {

    public static void printPrimes(int n) {

        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i + i; j < primes.length; j=j+i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPrimes(n);
    }
}
