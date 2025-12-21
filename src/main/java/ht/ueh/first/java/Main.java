package ht.ueh.first.java;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1, 1000);

        System.out.println("=== SIMULATION MULTI-CLIENTS ATM ===");

        for (int i = 1; i <= 10; i++) {
            Thread client = new Thread(
                    new ATMTask(account),
                    "Client-" + i
            );
            client.start();
        }
    }
}
