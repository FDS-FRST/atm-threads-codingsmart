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
            throw new InvalidAmountException ("Le Montant" + amount +"est invalide, les valeurs negatives ne sont pas acceptees");
        } 
        balance += amount;
        System.out.println("Dépôt de " + amount + " € | Nouveau solde : " + balance);
    }

    public synchronized void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException(
                    "Montant de retrait invalide : " + amount
            );
        }

        if(amount>balance){
            throw new InsufficientFundsException(
                    "Fonds insuffisants : solde = " + balance
                            + ", retrait demandé = " + amount
            );        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName()
                + " | Retrait de " + amount + " € | Solde : " + balance);
    }

    public synchronized double getBalance(){
        return balance;
    }

}
