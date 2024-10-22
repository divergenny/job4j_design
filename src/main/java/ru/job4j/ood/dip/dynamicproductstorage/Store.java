package ru.job4j.ood.dip.dynamicproductstorage;

import ru.job4j.ood.dip.dynamicproductstorage.model.Food;

import java.time.LocalDate;
import java.util.List;

public interface Store {
    boolean addToSpecificStoreByConditions(LocalDate currentDate, Food food);

    Food add(Food food);

    Food findById(int id);

    List<Food> findAll();

    boolean delete(int id);

    void deleteAll();
}
