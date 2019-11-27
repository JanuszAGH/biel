package pl.janusz.purcell.pt11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public class Runner {

    public static final int NUMBER_OF_TRANSFERS = 1_00;
    public static final int NUMBER_OF_ACCOUNTS = 10;
    public static final int NUMBER_OF_THREADS = 31;
    protected static AtomicInteger transfersMade=new AtomicInteger(0);
    List<Account> accounts = new ArrayList<>();
    private Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        new Runner().start();
    }

    private void start() throws InterruptedException {

        for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++) {
            Account e = new Account(i);
            e.deposit(10_000);
            accounts.add(e);
        }

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads.add(new Thread(new TransferRunnable()));
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        for (Account account : accounts) {
            System.out.println(account.getBalance());
        }
        int sum = accounts
                .stream()
                .mapToInt(Account::getBalance)
                .sum();
        System.out.println();
        System.out.println(sum);
        System.out.println();
        System.out.println(transfersMade.get());
        int totalTransfers = NUMBER_OF_THREADS*NUMBER_OF_TRANSFERS;
        int missed = totalTransfers-transfersMade.get();
        System.out.println(missed);
    }

    private class TransferRunnable implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < NUMBER_OF_TRANSFERS; i++) {
                int a1 = random.nextInt(NUMBER_OF_ACCOUNTS);
                int a2 = (random.nextInt(NUMBER_OF_ACCOUNTS - 1) + 1) % NUMBER_OF_ACCOUNTS;
                try {
                    Account.transfer(accounts.get(a1), accounts.get(a2), random.nextInt(100));
                } catch (InterruptedException e) {
                }
                try {
                    TimeUnit.MICROSECONDS.sleep(random.nextInt(3));
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
