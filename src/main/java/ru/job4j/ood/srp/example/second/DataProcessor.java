package ru.job4j.ood.srp.example.second;

/**
 * Класс отвечает как за обработку данных, так и за работу с файлами,
 * что нарушает принцип единственной ответственности (SRP).
 * Если потребуется изменить логику работы с файлами, это не должно затрагивать логику обработки данных.
 * Решение: Разделить функциональность работы с файлами в отдельный класс.
 * class DataProcessor (processData()) и class FileHandler (saveToFile(String filename),
 * loadFromFile(String filename) ).
 * Метод processData() - должен содержать логику обработки данных.
 * Метод saveToFile(String filename) - должен содержать логику сохранения данных в файл.
 * Метод loadFromFile(String filename) - должен содержать логику загрузки данных из файла.
 */
public class DataProcessor {
    public void processData() {
    }

    public void saveToFile(String filename) {
    }

    public void loadFromFile(String filename) {
    }
}
