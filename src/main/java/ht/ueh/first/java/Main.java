package ht.ueh.first.java;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1, 1000);

        Thread t1 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 700),
                "Client-1"
        );

        Thread t2 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 700),
                "Client-2"
        );

        t1.start();
        t2.start();
        /*
        Quel solde attend-on théoriquement ?
            R.:  Solde théorique : 1000 - 700 - 700 = -400, impossible en théorie.
        Quel solde observez-vous parfois ?
            R.: Selon l’exécution des threads, Solde observé parfois: -400 ou 300.
        Pourquoi les deux retraits peuvent-ils réussir ?
             R.: Les deux retraits peuvent réussir car les threads accèdent en même temps au solde avant sa mise à jour.
        Comment appelle-t-on ce type de problème ?
          on appelle ce type de problème : race condition.

         */
    }
}

