package ht.ueh.first.java;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1, 1000);

        Thread t1 = new Thread(
                new ATMTask( account,ATMTask.Action.WITHDRAW,300,1)
        );


        Thread t2 = new Thread(
                new ATMTask( account,ATMTask.Action.WITHDRAW,2000,2)

        );

        Thread t3 = new Thread(
                new ATMTask( account,ATMTask.Action.WITHDRAW,-50,3)

        );

        Thread t4 = new Thread(
                new ATMTask( account,ATMTask.Action.WITHDRAW,0,4)

        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }
}
