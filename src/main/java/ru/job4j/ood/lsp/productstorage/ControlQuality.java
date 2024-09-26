package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;

import java.time.LocalDate;
import java.util.List;

public class ControlQuality {

    public void sortProductToStore(LocalDate currentDate, Food food, List<Store> stores) {
        for (Store store : stores) {
            if (store.addToSpecificStoreByConditions(currentDate, food)) {
                break;
            }
        }
    }
}
