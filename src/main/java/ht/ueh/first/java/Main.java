package ht.ueh.first.java;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1, 1000);

        // Thread 1 : Retrait de 700 €
        Thread t1 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 700),
                "Client-1"
        );

        // Thread 2 : Retrait de 700 €
        Thread t2 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 700),
                "Client-2"
        );

        // Lancer les deux threads simultanément
        t1.start();
        t2.start();
    }
}
