package ru.job4j.ood.lsp.carparking;

import java.util.List;

public interface ParkingPlace {
    boolean add(Vehicle vehicle);

    List<Vehicle> findAll();

    boolean addVehicleToSpecificParkingPlace(Vehicle vehicle);

    TypeOfVehicle getTypeOfVehicleParkingPlace();

    int getOverallParkingPlaceSize();

    int getAvailableParkingPlaceSize();

    boolean isAvailableToParking(Vehicle vehicle);

    int setAvailableParkingPlaceSize(Vehicle vehicle);
}
