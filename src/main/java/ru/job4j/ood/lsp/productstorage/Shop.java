package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;
import ru.job4j.ood.lsp.productstorage.service.CalculateForExpirationDate;

import java.time.LocalDate;

public class Shop extends AbstractStore {
    public Shop() {
    }

    public Shop(Food food) {
        super(food);
    }


    @Override
    public boolean addToSpecificStoreByConditions(LocalDate currentDate, Food food) {
        CalculateForExpirationDate calc = new CalculateForExpirationDate();
        double ratio = calc.calcRatioExpDatePercentage(currentDate, food);
        if (ratio >= 25 && ratio <= 75) {
            add(food);
            return true;
        } else if (ratio > 75 && ratio < 100) {
            food.setPrice(food.getPrice() - (food.getPrice() * 0.2));
            add(food);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Shop{"
                + "foods=" + foods
                + '}';
    }

}
