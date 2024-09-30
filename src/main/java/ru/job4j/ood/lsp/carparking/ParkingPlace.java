package ru.job4j.ood.lsp.carparking;

import java.util.List;

public interface ParkingPlace {
    boolean add(Vehicle vehicle);

    List<Vehicle> findAll();

    boolean checkConditions(Vehicle vehicle);
}
