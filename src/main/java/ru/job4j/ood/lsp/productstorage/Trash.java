package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;

public class Trash extends AbstractStore {
    public Trash() {
    }

    public Trash(Food food) {
        super(food);
    }


    @Override
    public boolean addToSpecificStoreByConditions(Food food, double ratio,
                                                  long daysLeftToExpirationDate, long quantityOfAllStorageLife) {
        if (daysLeftToExpirationDate < 1) {
            add(food);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Trash{"
                + "foods=" + foods
                + '}';
    }
}
