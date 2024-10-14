package ru.job4j.ood.isp.example.second;

public class CreditAccount implements BankOperations {
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
        System.out.println("Checking conditions for credit..");
    }

    @Override
    public void issueCreditCard() {
        System.out.println("Card preparing..");
    }
}
