package ht.ueh.first.java;

public class BankAccount {

    private int accountNumber;
    private double balance;


    public BankAccount(int accountNumber, double balance) {

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " | Dépôt de " + amount + " € | Nouveau solde : " + balance);

    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " | Retrait refusé : solde insuffisant");

        } else {
            System.out.println(Thread.currentThread().getName()
                    + " | Retrait refusé : solde insuffisant");

        }
    }

    public synchronized double getBalance() {
        return balance;
    }

}
