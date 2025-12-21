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

    public ATMTask(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            Action action = Action.values()[random.nextInt(Action.values().length)];
            double amount = 100 + random.nextInt(400); // 100 à 500 €

            switch (action) {
                case DEPOSIT:
                    account.deposit(amount);
                    break;

                case WITHDRAW:
                    account.withdraw(amount);
                    break;

                case BALANCE:
                    System.out.println(Thread.currentThread().getName()
                            + " | Consultation solde : "
                            + account.getBalance() + " €");
                    break;
            }

            try {
                Thread.sleep(500); // Simulation du temps d’attente à l’ATM
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
