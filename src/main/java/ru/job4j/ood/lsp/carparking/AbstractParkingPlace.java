package ru.job4j.ood.lsp.carparking;

import java.util.List;

public abstract class AbstractParkingPlace implements ParkingPlace {
    @Override
    public boolean add(Vehicle vehicle) {
        return false;
    }
    @Override
    public List<Vehicle> findAll() {
        return null;
    }
}
