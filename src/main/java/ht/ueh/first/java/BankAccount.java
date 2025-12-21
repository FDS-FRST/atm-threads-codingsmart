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
            throw new InvalidAmounException ("Le Montant" + amount "est invalide, les valeurs negatives ne sont pas acceptees");
        } 
        balance += amount;
        System.out.println("Dépôt de " + amount + " € | Nouveau solde : " + balance);
    }

    public synchronized void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmounException ("Vous ne pouvez pas retirer ce montant de " + amount + " €, entrez une valeur superieure a zero");
        }  

        if(amount>balance){
            throw new InsufficientFundsException ("Votre balance est insuffisante, veuillez entrer une valeur inferieure a" + balance);
        }  
            balance -= amount;
            System.out.println("Retrait de " + amount + " € | Nouveau solde : " + balance);
        } else {
            System.out.println("Retrait refusé : solde insuffisant");
        }
    }

    public double getBalance(){
        return balance;
    }

}
