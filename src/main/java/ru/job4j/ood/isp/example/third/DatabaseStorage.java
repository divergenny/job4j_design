package ru.job4j.ood.isp.example.third;

public class DatabaseStorage implements DataStorage {
    @Override
    public void loadFromFile() {
        System.out.println("Loading from file..");
    }

    @Override
    public void saveToFile(Object data) {
        System.out.println("Saving to file..");
    }

    @Override
    public void loadFromDatabase() {
        System.out.println("Loading from database..");
    }

    @Override
    public void saveToDatabase(Object data) {
        System.out.println("Saving to database..");
    }
}
