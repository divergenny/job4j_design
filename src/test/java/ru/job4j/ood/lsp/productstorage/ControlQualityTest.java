package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.model.Food;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlQualityTest {

    Food firstFoodWarehouse;
    Food secondFoodShop;
    Food thirdFoodShopWithDiscount;
    Food fourthFoodTrash;
    Food fifthFoodTrash;
    LocalDate currentDate;
    ControlQuality cq;
    Store warehouse;
    Store shop;
    Store trash;
    List<Store> listOfStores;

    @BeforeEach
    void init() {
        firstFoodWarehouse = new Food("Cheese",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2025, 9, 16),
                100,
                0);
        secondFoodShop = new Food("Cake-cottage-cheese",
                LocalDate.of(2024, 9, 20),
                LocalDate.of(2024, 10, 5),
                100,
                0);
        thirdFoodShopWithDiscount = new Food("Cake-raspberry",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 28),
                100,
                0);
        fourthFoodTrash = new Food("Butter",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 25),
                100,
                0);
        fifthFoodTrash = new Food("Bread",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 10),
                100,
                0);
        currentDate = LocalDate.of(2024, Month.SEPTEMBER, 25);
        cq = new ControlQuality();
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        listOfStores = new ArrayList<>();
        listOfStores.add(warehouse);
        listOfStores.add(shop);
        listOfStores.add(trash);
        cq.sortProductToStore(firstFoodWarehouse, listOfStores, currentDate);
        cq.sortProductToStore(secondFoodShop, listOfStores, currentDate);
        cq.sortProductToStore(thirdFoodShopWithDiscount, listOfStores, currentDate);
        cq.sortProductToStore(fourthFoodTrash, listOfStores, currentDate);
        cq.sortProductToStore(fifthFoodTrash, listOfStores, currentDate);
    }

    @Test
    void whenCheckWarehouseStore() {
        List<Food> expected = List.of(firstFoodWarehouse);
        assertThat(warehouse.findAll()).isEqualTo(expected);
    }

    @Test
    void whenCheckShopStore() {
        List<Food> expected = List.of(secondFoodShop, thirdFoodShopWithDiscount);
        assertThat(shop.findAll()).isEqualTo(expected);
    }

    @Test
    void whenCheckShopStorePriceWithDiscount() {
        assertThat(shop.findById(2).getPrice()).
                isEqualTo(80.0);
    }

    @Test
    void whenCheckTrashStore() {
        List<Food> expected = List.of(fourthFoodTrash, fifthFoodTrash);
        assertThat(trash.findAll()).isEqualTo(expected);
    }
}
