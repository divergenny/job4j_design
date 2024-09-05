package ru.job4j.ood.lsp.example.third;

import java.util.ArrayList;
import java.util.List;

/**
 * DataFetcher возвращает список всех доступных данных.
 * Подкласс LimitedDataFetcher изменяет постусловие, возвращая только часть данных.
 * Клиент, который рассчитывает на получение всех данных,
 * может столкнуться с проблемами, используя подкласс LimitedDataFetcher,
 * что нарушает принцип Liskov Substitution Principle.
 * Метод fetchData() - должен содержать логику получения всех данных.
 */
public class DataFetcher {
    public List<String> fetchData() {
        return new ArrayList<>();
    }
}
