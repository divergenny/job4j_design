package ru.job4j.ood.dip.dynamicproductstorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.dip.dynamicproductstorage.model.Food;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControlQualityTest {

    private Food firstFoodWarehouse;
    private Food secondFoodShop;
    private Food thirdFoodShopWithDiscount;
    private Food fourthFoodTrash;
    private Food fifthFoodTrash;
    private LocalDate currentDate;
    private Store warehouse;
    private Store shop;
    private Store trash;
    private List<Store> listOfStores;

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
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        listOfStores = new ArrayList<>();
        listOfStores.add(warehouse);
        listOfStores.add(shop);
        listOfStores.add(trash);
    }

    @Test
    void whenCheckWarehouseStore() {
        ControlQuality cq = new ControlQuality(listOfStores);
        cq.sortProductToStore(currentDate, firstFoodWarehouse);
        cq.sortProductToStore(currentDate, secondFoodShop);
        cq.sortProductToStore(currentDate, thirdFoodShopWithDiscount);
        cq.sortProductToStore(currentDate, fourthFoodTrash);
        cq.sortProductToStore(currentDate, fifthFoodTrash);
        List<Food> expected = List.of(firstFoodWarehouse);
        assertThat(warehouse.findAll()).isEqualTo(expected);
    }

    @Test
    void whenCheckShopStore() {
        ControlQuality cq = new ControlQuality(listOfStores);
        cq.sortProductToStore(currentDate, firstFoodWarehouse);
        cq.sortProductToStore(currentDate, secondFoodShop);
        cq.sortProductToStore(currentDate, thirdFoodShopWithDiscount);
        cq.sortProductToStore(currentDate, fourthFoodTrash);
        cq.sortProductToStore(currentDate, fifthFoodTrash);
        List<Food> expected = List.of(secondFoodShop, thirdFoodShopWithDiscount);
        assertThat(shop.findAll()).isEqualTo(expected);
    }

    @Test
    void whenCheckShopStorePriceWithDiscount() {
        ControlQuality cq = new ControlQuality(listOfStores);
        cq.sortProductToStore(currentDate, firstFoodWarehouse);
        cq.sortProductToStore(currentDate, secondFoodShop);
        cq.sortProductToStore(currentDate, thirdFoodShopWithDiscount);
        cq.sortProductToStore(currentDate, fourthFoodTrash);
        cq.sortProductToStore(currentDate, fifthFoodTrash);
        assertThat(shop.findById(2).getPrice()).
                isEqualTo(80.0);
    }

    @Test
    void whenCheckTrashStore() {
        ControlQuality cq = new ControlQuality(listOfStores);
        cq.sortProductToStore(currentDate, firstFoodWarehouse);
        cq.sortProductToStore(currentDate, secondFoodShop);
        cq.sortProductToStore(currentDate, thirdFoodShopWithDiscount);
        cq.sortProductToStore(currentDate, fourthFoodTrash);
        cq.sortProductToStore(currentDate, fifthFoodTrash);
        List<Food> expected = List.of(fourthFoodTrash, fifthFoodTrash);
        assertThat(trash.findAll()).isEqualTo(expected);
    }

    @Test
    void whenResortProducts() {
        ControlQuality cq = new ControlQuality(listOfStores);
        cq.sortProductToStore(currentDate, firstFoodWarehouse);
        cq.sortProductToStore(currentDate, secondFoodShop);
        cq.sortProductToStore(currentDate, thirdFoodShopWithDiscount);
        cq.sortProductToStore(currentDate, fourthFoodTrash);
        cq.sortProductToStore(currentDate, fifthFoodTrash);
        cq.resort(currentDate);
        List<Food> warehouseExpected = List.of(firstFoodWarehouse);
        List<Food> shopExpected = List.of(secondFoodShop, thirdFoodShopWithDiscount);
        List<Food> trashExpected = List.of(fourthFoodTrash, fifthFoodTrash);
        assertThat(warehouse.findAll()).isEqualTo(warehouseExpected);
        assertThat(shop.findAll()).isEqualTo(shopExpected);
        assertThat(trash.findAll()).isEqualTo(trashExpected);
    }
}
