package ru.job4j.ood.dip.dynamicproductstorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.dip.dynamicproductstorage.model.Food;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrashTest {
    private Food firstFood;
    private Food secondFood;
    private Food thirdFood;

    @BeforeEach
    void init() {
        firstFood = new Food("Cheese",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2025, 9, 16),
                100,
                0);
        secondFood = new Food("Cake",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 16),
                100,
                0);
        thirdFood = new Food("Butter",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 3),
                100,
                0);
    }

    @Test
    void whenFindByIdEqualTo2ThenSecondFood() {
        Store warehouse = new Warehouse();
        warehouse.add(firstFood);
        warehouse.add(secondFood);
        warehouse.add(thirdFood);
        assertThat(warehouse.findById(2)).isEqualTo(secondFood);
    }

    @Test
    void whenFindAll() {
        Store warehouse = new Warehouse();
        warehouse.add(firstFood);
        warehouse.add(secondFood);
        warehouse.add(thirdFood);
        List<Food> expected = List.of(firstFood, secondFood, thirdFood);
        assertThat(warehouse.findAll()).isEqualTo(expected);
    }

    @Test
    void whenDeleteSecondThenListOfFirstAndThird() {
        Store warehouse = new Warehouse();
        warehouse.add(firstFood);
        warehouse.add(secondFood);
        warehouse.add(thirdFood);
        warehouse.delete(2);
        List<Food> expected = List.of(firstFood, thirdFood);
        assertThat(warehouse.findAll()).isEqualTo(expected);
    }

    @Test
    void whenAddThenFindAll() {
        Store warehouse = new Warehouse();
        warehouse.add(firstFood);
        warehouse.add(secondFood);
        warehouse.add(thirdFood);
        Food fourthFood = new Food("Bread",
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 3),
                100,
                0);
        warehouse.add(fourthFood);
        List<Food> expected = List.of(firstFood, secondFood, thirdFood, fourthFood);
        assertThat(warehouse.findAll()).isEqualTo(expected);
    }
}
