package ht.ueh.first.java;

import java.io.IOException;


public class ATMTask implements Runnable {

    public enum Action {
        DEPOSIT,
        WITHDRAW,
        BALANCE
    }

    private BankAccount account;
    private Action action;
    private double amount;
    private int idClient;

    public ATMTask(BankAccount account, Action action, double amount, int IdClient){
        this.account = account;
        this.action = action;
        this.amount = amount;
        this.idClient = idClient;
    }

    @Override
    public void run() {
        try {
            switch (action) {
                case Action.DEPOSIT:
                    account.deposit(amount);
                    System.out.println(log("Dépôt de " + amount + " € effectué avec succès. " ));
                    break;
                case WITHDRAW:
                    account.withdraw(amount);
                    System.out.println(log("Retrait de " + amount + " € effectué avec succès. " ));
                    break;
                case BALANCE:
                    System.out.println(Thread.currentThread().getName()
                            + " | La balance du compte est : " + account.getBalance() + " €");
                    System.out.println(log("Balance consultée avec succès. "));
                    break;
                default:
                    //Capture de l'exception au niveau du thread pour ne pas remonter dans Main et impacter le thread principal
                    throw new IllegalArgumentException("ACTION HORS CONTEXTE");
            }
        }
        catch (IllegalArgumentException e) {
            Thread.currentThread().interrupt();
            System.err.println(log("Interruption du thread"));
        }
        //précision sur l’action, le montant et la raison
        catch(InvalidAmountException e){
            System.err.println(log("La tentative de dépot de " + amount + " € a échouée, car le montant entré est inférieure ou égale à zéro. " + e.getMessage()));
        }
        catch(InsufficientFundsException e){
            System.err.println(log("La tentative de retrait de " + amount + " € a échouée, car votre balance n'est pas suffisante. " + e.getMessage()));
        }
        finally{
            System.out.println();
        }

        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interruption du thread : " + Thread.currentThread().getName());
        }
    }

    //Methode de journalisation des threads permettant de savoir quel client a effectué quelle operation selon un flux d'éxécution
    private String log(String message){
        return "[Client " + idClient +
                " | " + Thread.currentThread().getName() +
                "] " + message;
    }
}
