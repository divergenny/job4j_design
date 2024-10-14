package ru.job4j.ood.isp.example.second;

public class BasicAccount implements BankOperations {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposit working..");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Money sending..");
    }

    @Override
    public void creditApproval() {
        throw new Error("Not implemented");
    }

    @Override
    public void issueCreditCard() {
        throw new Error("Not implemented");
    }
}
