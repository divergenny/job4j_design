package ru.job4j.ood.lsp.productstorage.service;

import ru.job4j.ood.lsp.productstorage.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculateForExpirationDate {

    public double calcDaysLeftToExpirationDate(LocalDate currentDate, Food food) {
        return ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
    }

    public double calcQuantityOfAllStorageLife(Food food) {
        return ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
    }

    public double calcRatioExpDatePercentage(LocalDate currentDate, Food food) {
        return 100 - ((double) calcDaysLeftToExpirationDate(currentDate, food) * 100)
                / calcQuantityOfAllStorageLife(food);
    }
}
