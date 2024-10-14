package ru.job4j.ood.isp.example.second;

/**
 * Интерфейс включает методы для разных банковских операций.
 * Если класс, реализующий интерфейс, занимается только базовыми операциями,
 * такими как внесение депозитов и снятие средств,
 * методы creditApproval и issueCreditCard приводят к
 * нарушению принципа разделения интерфейсов (Interface Segregation Principle).
 */
public interface BankOperations {
    void deposit(double amount);

    void withdraw(double amount);

    void creditApproval();

    void issueCreditCard();
}
