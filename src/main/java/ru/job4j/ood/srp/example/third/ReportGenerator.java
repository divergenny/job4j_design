package ru.job4j.ood.srp.example.third;

/**
 * Класс отвечает как за генерацию отчётов, так и за операции с базой данных.
 * Это две разные ответственности, что нарушает принцип единственной ответственности (SRP).
 * Решение: Разделить функциональность работы с базой данных в отдельный класс.
 * class ReportGenerator (generateReport() ), class DatabaseConnector (connectToDatabase(),
 * executeQuery(String query) ).\
 * Метод generateReport() - должен содержать логику генерации отчёта.
 * Метод connectToDatabase() - должен содержать логику подключения к базе данных.
 * Метод executeQuery(String query) - должен содержать логику выполнения запроса к базе данных.
 */
public class ReportGenerator {
    public void generateReport() {
    }

    public void connectToDatabase() {
    }

    public void executeQuery(String query) {
    }
}
