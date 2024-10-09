package ru.job4j.ood.lsp.carparking;

import java.util.List;

public class TruckParkingPlace extends AbstractParkingPlace {
    int size;

    public TruckParkingPlace(int size) {
        this.size = size;
    }

    @Override
    public boolean addVehicleToSpecificParkingPlace(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean checkConditions(Vehicle vehicle) {
        return false;
    }

    @Override
    public TypeOfVehicle getTypeOfVehicleParkingPlace() {
        return null;
    }

    @Override
    public int getOverallParkingPlaceSize() {
        return 0;
    }

    @Override
    public int getAvailableParkingPlaceSize() {
        return 0;
    }

    @Override
    public boolean isAvailableToParking(Vehicle vehicle) {
        return false;
    }
}
