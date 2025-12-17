package ht.ueh.first.java;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1, 1000);

        Thread t1 = new Thread(
                new ATMTask(account, ATMTask.Action.DEPOSIT, 300),
                "Client-1"
        );

        Thread t2 = new Thread(
                new ATMTask(account, ATMTask.Action.BALANCE, 0),
                "Client-2"
        );

        t1.start();
        t2.start();
    }
}

