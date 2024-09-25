package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;

import java.util.List;

public interface Store {
    boolean addToSpecificStoreByConditions(Food food, double ratio, long daysLeftToExpirationDate, long quantityOfAllStorageLife);

    Food add(Food food);

    Food findById(int id);

    List<Food> findAll();

    boolean delete(int id);
}
