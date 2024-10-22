package ru.job4j.ood.dip.dynamicproductstorage;

import ru.job4j.ood.dip.dynamicproductstorage.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected final short twentyFiveBorder = 25;
    protected final short seventyFiveBorder = 75;
    protected final short oneHundredBorder = 100;
    protected final double discountMultiplier = 0.2;
    protected final short daysLeftToExpirationDateForTrash = 1;

    protected List<Food> foods = new ArrayList<>();

    private int ids = 1;

    public AbstractStore() {
    }

    public AbstractStore(Food food) {
        add(food);
    }

    public int getIds() {
        return ids;
    }

    private void setIds(int ids) {
        this.ids = ids;
    }

    @Override
    public Food add(Food food) {
        food.setId(ids++);
        foods.add(food);
        return food;
    }

    @Override
    public Food findById(int id) {
        for (Food food : foods) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (null != findById(id)) {
            for (int index = 0; index < foods.size(); index++) {
                if (foods.get(index).getId() == id) {
                    foods.remove(index);
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(foods);
    }

    @Override
    public void deleteAll() {
        foods = new ArrayList<>();
    }

}
