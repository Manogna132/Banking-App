package com.service;

import com.model.Bank;
import com.repository.BankRepo;

public class BankService {
    private final BankRepo repo;

    public BankService(BankRepo repo) {
        this.repo = repo;
    }

    public void addAccount(Bank bank) {
        if (!repo.exists(bank.getAccountNumber())) {
            repo.save(bank);
        } else {
            System.out.println("Account already exists.");
        }
    }

    public void withdrawAmount(long accountNumber, double amount) {
        Bank account = repo.findByAccountNumber(accountNumber);
        if (account != null) {
            if (amount > 0 && account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                repo.save(account); 
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void depositAmount(long accountNumber, double amount) {
        Bank account = repo.findByAccountNumber(accountNumber);
        if (account != null) {
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
                repo.save(account);
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public Bank getDataByAccountNo(long accountNumber) {
        return repo.findByAccountNumber(accountNumber);
    }
}
