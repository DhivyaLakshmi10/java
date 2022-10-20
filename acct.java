import java.lang.*;
import java.util.Scanner;
class Account extends Thread{
    private double balance;

    public Account(double initialDeposit) {
        balance = initialDeposit;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {

                balance += amount;
                notify();
    }

    public synchronized void withdraw(double amount) throws InterruptedException {
        if ( balance >= amount ) { balance -= amount; }
        else {
            Thread.sleep(1000);
        }
    }    // no negative balance allowed

}
public class ts5
{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your choice");
        System.out.println("1.Deposit\n2.Withdraw");
        Integer n = sc.nextInt();
        Account acc = new Account(0);
        int f =-1;
        while(f!=1) {
            if (n == 1) {
                System.out.println("Enter the amount to be deposited");
                Double bal = sc.nextDouble();
                acc.deposit(bal);
                System.out.println("Amount has been deposited Successfully");
            } else {
                System.out.println("Enter the amount to be Withdrawn");
                Double amt = sc.nextDouble();
                acc.withdraw(amt);
                System.out.println("Remaining balance is "+acc.getBalance());
            }
            System.out.println("Do you want to Continue : ");
            sc.nextLine();
            String s = sc.nextLine();
            if (s.equals("Yes")) {
                f = 0;
                System.out.println("Enter your Choice");
                n = sc.nextInt();
            } else {
                f = 1;
            }
        }

    }
}
