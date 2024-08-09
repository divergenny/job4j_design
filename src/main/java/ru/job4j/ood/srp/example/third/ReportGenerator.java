package ru.job4j.ood.srp.example.third;

/**
 * Класс отвечает как за генерацию отчётов, так и за операции с базой данных.
 * Это две разные ответственности, что нарушает принцип единственной ответственности (SRP).
 * Решение: Разделить функциональность работы с базой данных в отдельный класс.
 * class ReportGenerator (generateReport() ), class DatabaseConnector (connectToDatabase(),
 * executeQuery(String query) ).
 */
public class ReportGenerator {
    public void generateReport() {
        // Логика генерации отчета
    }

    public void connectToDatabase() {
        // Логика подключения к базе данных
    }

    public void executeQuery(String query) {
        // Логика выполнения запроса к базе данных
    }
}
