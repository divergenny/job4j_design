package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControlQuality {

    public void sortProductToStore(Food food, List<Store> stores, LocalDate currentDate) {
        long daysLeftToExpirationDate = ChronoUnit.DAYS.between(currentDate, food.getExpiryDate());
        long quantityOfAllStorageLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double ratioExpirationDatePercentage = 100 - (double) daysLeftToExpirationDate * 100 / quantityOfAllStorageLife;
        for (Store store : stores) {
            if (store.addToSpecificStoreByConditions(food,
                    ratioExpirationDatePercentage,
                    daysLeftToExpirationDate,
                    quantityOfAllStorageLife)) {
                break;
            }
        }
    }
}
