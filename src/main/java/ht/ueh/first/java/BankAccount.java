package ht.ueh.first.java;

public class BankAccount {

    private int accountNumber;
    private double balance;


    public BankAccount (int accountNumber, double balance) {

        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) throws InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException (" Veuillez entrer une valeur supérieure à zéro.\n");
        } 
        balance += amount;
        System.out.println("Dépôt de " + amount + " € | Nouveau solde : " + balance + " €.\n");
    }

    public synchronized void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException (" Vous ne pouvez pas retirer ce montant de " + amount + " €, entrez une valeur supérieure ou égale à zéro.\n");
        }  

        if(amount>balance){
            throw new InsufficientFundsException (" Veuillez entrer une valeur inférieure à " + balance + " €.\n");
        }
        balance -= amount;
        System.out.println("TRANSACTION RÉUSSIE : \nUn montant de " + amount + " € a été retiré.");
    }

    public synchronized double getBalance(){
        return balance;
    }

}
