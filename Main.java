//Class definition, creating objects and constructors: 
//Write a java program to create a class named 'Bank ' with the following data 
//members: 
// Name of depositor 
// Address of depositor 
// Account Number 
// Balance in account  
//Class 'Bank' has a method for each of the following: 
//1. Generate a unique account number for each depositor. 
//2. For first depositor, account number will be 1001, for second depositor 
//it will be 1002 and so on 
//3. Display information and balance of depositor 
//4. Deposit more amount in balance of any depositor 
//5. Withdraw some amount from balance deposited. 
//6. Change address of depositor  
//2 After creating the class, do the following operations. 
//1. Enter the information (name, address, account number, balance) of the 
//depositors. Number of depositors is to be entered by the user. 
//2. Print the information of any depositor. 
//3. Add some amount to the account of any depositor and then display 
//final information of that depositor. 
//4. Remove some amount from the account of any. 
//depositor and then display final information of that depositor. 
//5. Change the address of any depositor and then display the final 
//information of that depositor. 
//6. Randomly repeat these processes for some other 
//bank accounts.
 
import java.util.ArrayList;
import java.util.Scanner;

class Bank {
    private static int accountCounter = 1000;
    private String name;
    private String address;
    private int accountNumber;
    private double balance;

    public Bank(String name, String address, double balance) {
        this.name = name;
        this.address = address;
        this.accountNumber = ++accountCounter;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " successfully.");
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal.");
        }
    }

    public void changeAddress(String newAddress) {
        address = newAddress;
        System.out.println("Address updated successfully.");
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Bank> bankAccounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of depositors: ");
        int numDepositors = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numDepositors; i++) {
            System.out.println("Enter details for depositor " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Initial balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            bankAccounts.add(new Bank(name, address, balance));
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Display depositor information");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Change address");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    boolean found = false;
                    for (Bank account : bankAccounts) {
                        if (account.getAccountNumber() == accNumber) {
                            account.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    found = false;
                    for (Bank account : bankAccounts) {
                        if (account.getAccountNumber() == accNumber) {
                            account.deposit(depositAmount);
                            account.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    found = false;
                    for (Bank account : bankAccounts) {
                        if (account.getAccountNumber() == accNumber) {
                            account.withdraw(withdrawAmount);
                            account.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found or insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    found = false;
                    for (Bank account : bankAccounts) {
                        if (account.getAccountNumber() == accNumber) {
                            account.changeAddress(newAddress);
                            account.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        scanner.close();
    }
}
