package ru.job4j.ood.isp.example.third;

public class FileStorage implements DataStorage {

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
        throw new Error("Not implemented");
    }

    @Override
    public void saveToDatabase(Object data) {
        throw new Error("Not implemented");
    }
}
