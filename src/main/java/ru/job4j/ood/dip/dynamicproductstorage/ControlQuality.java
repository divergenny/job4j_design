package ru.job4j.ood.dip.dynamicproductstorage;

import ru.job4j.ood.dip.dynamicproductstorage.model.Food;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void resort(LocalDate currentDate) {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.findAll());
            store.deleteAll();
        }
        for (Food food : foods) {
            sortProductToStore(currentDate, food);
        }
    }

    public void sortProductToStore(LocalDate currentDate, Food food) {
        for (Store store : stores) {
            if (store.addToSpecificStoreByConditions(currentDate, food)) {
                break;
            }
        }
    }
}
