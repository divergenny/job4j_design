package ru.job4j.ood.lsp.productstorage.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Food {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private int id;
    private String name;
    private LocalDate createDate;
    private LocalDate expiryDate;

    private double price;
    private double discount;

    public Food(String name, LocalDate createDate, LocalDate expiryDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;

        if (discount != 0) {
            this.price = price - ((price * discount) / 100);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        if (discount != 0) {
            price = price - ((price * discount) / 100);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return id == food.id && Double.compare(food.price, price) == 0 && Double.compare(food.discount, discount) == 0 && Objects.equals(name, food.name) && Objects.equals(createDate, food.createDate) && Objects.equals(expiryDate, food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, expiryDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", createDate=" + FORMATTER.format(createDate)
                + ", expiryDate=" + FORMATTER.format(expiryDate)
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
