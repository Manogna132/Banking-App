package com.repository;

import com.model.Bank;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankRepo {
    private final Map<Long, Bank> accounts = new ConcurrentHashMap<>();

    public void save(Bank bank) {
        accounts.put(bank.getAccountNumber(), bank);
    }

    public Bank findByAccountNumber(long accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean exists(long accountNumber) {
        return accounts.containsKey(accountNumber);
    }
}
