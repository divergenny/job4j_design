package ru.job4j.ood.lsp.example.second;

/**
 * Усиление предусловий.
 * У класса Employee есть метод setSalary(double salary), устанавливающий зарплату.
 * Подкласс Manager усиливает предусловие, требуя, чтобы зарплата была не меньше определенного минимума.
 * Клиент, ожидающий, что метод setSalary работает для всех положительных значений,
 * столкнется с неожиданными исключениями при использовании подкласса Manager,
 * что нарушает принцип Liskov Substitution Principle.
 */
public class Employee {
    public void setSalary(double salary) {
        if (salary > 0) {
            System.out.println("Salary set");
        }
    }
}
