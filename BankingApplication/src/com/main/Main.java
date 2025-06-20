package com.main;

import java.util.Scanner;
import com.model.Bank;
import com.repository.BankRepo;
import com.service.BankService;

public class Main {
    static {
        System.out.println("Welcome!");
    }

    public static void main(String[] args) {
        BankRepo repo = new BankRepo();
        BankService bs = new BankService(repo);
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Show Details");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    long accNo = s.nextLong();
                    s.nextLine(); 
                    System.out.print("Enter Account Holder Name: ");
                    String name = s.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = s.nextDouble();

                    Bank bank = new Bank();
                    bank.setAccountNumber(accNo);
                    bank.setAccountHolderName(name); 
                    bank.setBalance(balance);
                    bs.addAccount(bank);
                    System.out.println("Account Created Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    long withdrawAccNo = s.nextLong();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = s.nextDouble();
                    bs.withdrawAmount(withdrawAccNo, withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    long depositAccNo = s.nextLong();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = s.nextDouble();
                    bs.depositAmount(depositAccNo, depositAmount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    long detailsAccNo = s.nextLong();
                    Bank accDetails = bs.getDataByAccountNo(detailsAccNo);
                    if (accDetails != null) {
                        System.out.println("Account Number: " + accDetails.getAccountNumber());
                        System.out.println("Account Holder: " + accDetails.getAccountHolderName());
                        System.out.println("Balance: " + accDetails.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    long balAccNo = s.nextLong();
                    Bank b = bs.getDataByAccountNo(balAccNo);
                    if (b != null) {
                        System.out.println("Current Balance: " + b.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you!");
                    s.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
