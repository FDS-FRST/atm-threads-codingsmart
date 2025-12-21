package ht.ueh.first.java;

public class Main {

    public static void main(String[] args) throws InvalidAmountException,InsufficientFundsException {

        BankAccount account = new BankAccount(1, 1000);

        account.deposit(200);
        account.withdraw(150);

        System.out.println("Solde final : " + account.getBalance() + " €");
    }
}
