package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;
import ru.job4j.ood.lsp.productstorage.service.CalculateForExpirationDate;

import java.time.LocalDate;

public class Trash extends AbstractStore {
    public Trash() {
    }

    public Trash(Food food) {
        super(food);
    }


    @Override
    public boolean addToSpecificStoreByConditions(LocalDate currentDate, Food food) {
        CalculateForExpirationDate calc = new CalculateForExpirationDate();
        double daysLeftToExpirationDate = calc.calcDaysLeftToExpirationDate(currentDate, food);
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
