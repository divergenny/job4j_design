package ru.job4j.ood.dip.dynamicproductstorage;

import ru.job4j.ood.dip.dynamicproductstorage.model.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    public void resort(LocalDate currentDate, List<Store> stores) {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.findAll());
            store.deleteAll();
        }
        for (Food food : foods) {
            sortProductToStore(currentDate, food, stores);
        }
    }

    public void sortProductToStore(LocalDate currentDate, Food food, List<Store> stores) {
        for (Store store : stores) {
            if (store.addToSpecificStoreByConditions(currentDate, food)) {
                break;
            }
        }
    }
}
