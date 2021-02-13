// Oluwatomisin Adedolapo Sobowale, QI78930.
// This project will take a look at banking operations like balances, deposit,withdraw, exit, etc.
// We will be using the concepts learnt in the java class which consist of class and objects, methods, elementary functions, loops, if/else statements, switch, constructors, etc.

import java.util.Scanner;
public class BankingApp {
    public static void main(String[] args){
        BankAccount object1= new BankAccount("Oluwatomisin Sobowale", "QI78930");
        object1.showmenu();
    }
}
//Creating a Bank account class that will contain the necessary for the banking application
class BankAccount {
    int balance;
    int PreviousTransaction;
    String CustomerID;
    String CustomerName;
    // Constructor containing the attributes
    BankAccount(String cname, String cid){
        CustomerID = cid;
        CustomerName = cname;

    }
    // deposit method function
    void deposit(int amount){
        if(amount !=0){
            balance = balance + amount;
            PreviousTransaction = amount;
        }
    }
    //withdraw method function
    void withdraw(int amount){
        if(amount !=0){
            balance = balance - amount;
            PreviousTransaction = -amount;
        }
    }
    // a getter method which will be using the if/else statement to give the optional outcomes for each transaction
    void getPreviousTransaction(){
        if(PreviousTransaction > 0){
            System.out.println("Deposited:"+PreviousTransaction);
        }
        else if(PreviousTransaction < 0){
            System.out.println("Withdrawn:"+Math.abs(PreviousTransaction));
        }
        else {
            System.out.println("No Transaction occured at that time");
        }
    }
    // this will contain the default constructor for showmenu
    void showmenu(){
        char option= '\0';
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome "+CustomerName);
        System.out.println("User ID is"+CustomerID);
        System.out.println("\n");
        System.out.println(" A.) Check Balance");
        System.out.println("B.) Deposit");
        System.out.println("C.) Withdraw");
        System.out.println("D.) Previous Transaction(s)");
        System.out.println("E.) EXIT");

        do {
            System.out.println("---------------------------------");
            System.out.println("Enter option");
            System.out.println("---------------------------------");
            option = scan.next().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'A':
                    System.out.println("-------------------------");
                    System.out.println("Balance ="+balance);
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("-------------------------");
                    System.out.println("Enter  amount to deposit");
                    System.out.println("-------------------------");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("-------------------------");
                    System.out.println("Enter amount to Withdraw");
                    System.out.println("-------------------------");
                    int amount2 = scan.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("-------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("********");
                    break;

                default:
                    System.out.println("Not valid. Enter again");
            }
        }
        while(option !='E');
        System.out.println("Thank you for using BankingApp");
    }
}

