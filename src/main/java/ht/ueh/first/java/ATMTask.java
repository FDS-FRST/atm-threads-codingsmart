package ht.ueh.first.java;

import java.util.Random;

public class ATMTask implements Runnable {


    public enum Action {
        DEPOSIT,
        WITHDRAW,
        BALANCE
    }

    private BankAccount account;
    private Random random = new Random();


    public ATMTask(BankAccount account, Action action, double amount) {
        this.account = account;
    }

    @Override
    public void run() {
        switch (action) {
            case DEPOSIT:
                account.deposit(amount);
                break;
            case WITHDRAW:
                account.withdraw(amount);
                break;
            case BALANCE:
                System.out.println(Thread.currentThread().getName()
                        + " | Solde : " + account.getBalance() + " €");
                break;
        }
    }
}
