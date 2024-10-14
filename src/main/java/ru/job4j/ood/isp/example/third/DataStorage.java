package ru.job4j.ood.isp.example.third;

/**
 * Интерфейс объединяет методы для работы с базой данных и файловой системой.
 * Если класс работает только с файлами,
 * ему все равно придется реализовывать методы для работы с базой данных,
 * что является нарушением принципа разделения интерфейсов (Interface Segregation Principle).
 */
public interface DataStorage {
    void loadFromFile();

    void saveToFile(Object data);

    void loadFromDatabase();

    void saveToDatabase(Object data);
}
