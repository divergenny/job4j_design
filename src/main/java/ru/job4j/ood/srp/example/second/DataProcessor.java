package ru.job4j.ood.srp.example.second;

/**
 * Класс отвечает как за обработку данных, так и за работу с файлами,
 * что нарушает принцип единственной ответственности (SRP).
 * Если потребуется изменить логику работы с файлами, это не должно затрагивать логику обработки данных.
 * Решение: Разделить функциональность работы с файлами в отдельный класс.
 * class DataProcessor (processData()) и class FileHandler (saveToFile(String filename),
 * loadFromFile(String filename) ).
 */
public class DataProcessor {
    public void processData() {
        // Логика обработки данных
    }

    public void saveToFile(String filename) {
        // Логика сохранения данных в файл
    }

    public void loadFromFile(String filename) {
        // Логика загрузки данных из файла
    }
}
