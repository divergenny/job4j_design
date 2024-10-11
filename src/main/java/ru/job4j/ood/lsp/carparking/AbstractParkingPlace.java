package ru.job4j.ood.lsp.carparking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractParkingPlace implements ParkingPlace {
    protected List<Vehicle> vehicles = new ArrayList<>();

    protected int overallParkingPlaceSize;
    protected int availableParkingPlaceSize;

    @Override
    public boolean add(Vehicle vehicle) {
        vehicles.add(vehicle);
        return true;
    }

    @Override
    public boolean addVehicleToSpecificParkingPlace(Vehicle vehicle) {
        if (isAvailableToParking(vehicle)) {
            add(vehicle);
            availableParkingPlaceSize = setAvailableParkingPlaceSize(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public List<Vehicle> findAll() {
        return List.copyOf(vehicles);
    }

    @Override
    public int getOverallParkingPlaceSize() {
        return overallParkingPlaceSize;
    }

    @Override
    public int getAvailableParkingPlaceSize() {
        return availableParkingPlaceSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractParkingPlace that = (AbstractParkingPlace) o;
        return overallParkingPlaceSize == that.overallParkingPlaceSize
                && availableParkingPlaceSize == that.availableParkingPlaceSize
                && Objects.equals(vehicles, that.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicles, overallParkingPlaceSize, availableParkingPlaceSize);
    }

    @Override
    public String toString() {
        return "AbstractParkingPlace{"
                + "vehicles=" + vehicles
                + ", overallParkingPlaceSize=" + overallParkingPlaceSize
                + ", availableParkingPlaceSize=" + availableParkingPlaceSize
                + '}';
    }
}
