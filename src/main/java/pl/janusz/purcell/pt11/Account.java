package pl.janusz.purcell.pt11;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public class Account {

    protected Lock lock = new ReentrantLock();
    private int balance;
    private int id;

    public Account(int id) {

        this.id = id;
    }

    public Account() {

        this(0);
    }

    public static void transfer(Account accountSrc, Account accountDest, int amount) throws InterruptedException {

        Lock first;
        Lock second;

        if (accountSrc.getId() < accountDest.getId()) {
            first = accountSrc.lock;
            second = accountDest.lock;
        } else {
            first = accountDest.lock;
            second = accountSrc.lock;
        }
        first.lock();
        try {
            second.lock();
            try {
                Runner.transfersMade.incrementAndGet();
                if (accountSrc.getBalance() >= amount) {
                    accountSrc.withdraw(amount);
                    accountDest.deposit(amount);
                }
            } finally {
                second.unlock();
            }
        } finally {
            first.unlock();
        }
    }

    public int getId() {

        return id;
    }

    public void deposit(int amount) {

        balance += amount;
    }

    public void withdraw(int amount) {

        if (balance - amount >= 0) {
            balance -= amount;
        }
    }

    public int getBalance() {

        return balance;
    }
}
