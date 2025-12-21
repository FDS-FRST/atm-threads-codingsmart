package ht.ueh.first.java;

public class BankAccount {

    private int accountNumber;
    private double balance;


    public BankAccount (int accountNumber, double balance) {

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void  deposit(double amount){
        balance += amount;
        System.out.println("Dépôt de " + amount + " € | Nouveau solde : " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Retrait de " + amount + " € | Nouveau solde : " + balance);
        } else {
            System.out.println("Retrait refusé : solde insuffisant");
        }
    }

    /*
    Pourquoi synchronized empêche-t-il la race condition ?
        R.: Parceque synchronized empêche la race condition en donnant l'accès d'exécution à un seul thread à la fois.
    Que se passe-t-il si plusieurs threads veulent entrer dans la méthode ?
        R.: Si plusieurs threads veulent entrer les autres attendent que le thread cours d'exécution soit terminé.

    *  */

    public double getBalance(){
        return balance;
    }

}
