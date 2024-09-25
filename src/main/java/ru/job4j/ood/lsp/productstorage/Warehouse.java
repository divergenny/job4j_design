package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;

public class Warehouse extends AbstractStore {
    public Warehouse() {
    }

    public Warehouse(Food food) {
        super(food);
    }


    @Override
    public boolean addToSpecificStoreByConditions(Food food, double ratio,
                                                  long daysLeftToExpirationDate, long quantityOfAllStorageLife) {
        if (ratio < 25) {
            add(food);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Warehouse{"
                + "foods=" + foods
                + '}';
    }
}
