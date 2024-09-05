package ru.job4j.ood.lsp.example.third;

import java.util.List;

/**
 * Метод fetchData() - содержит логику возвращения только части данных.
 */
public class LimitedDataFetcher extends DataFetcher {
    @Override
    public List<String> fetchData() {
        List<String> allData = super.fetchData();
        return allData.subList(0, Math.min(10, allData.size()));
    }
}
