package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;
import ru.job4j.ood.lsp.productstorage.service.CalculateForExpirationDate;

import java.time.LocalDate;

public class Warehouse extends AbstractStore {
    public Warehouse() {
    }

    public Warehouse(Food food) {
        super(food);
    }

    @Override
    public boolean addToSpecificStoreByConditions(LocalDate currentDate, Food food) {
        CalculateForExpirationDate calc = new CalculateForExpirationDate();
        double ratio = calc.calcRatioExpDatePercentage(currentDate, food);
        if (ratio < twentyFiveBorder) {
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
