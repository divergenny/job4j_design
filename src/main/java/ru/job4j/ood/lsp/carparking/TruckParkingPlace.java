package ru.job4j.ood.lsp.carparking;

import java.util.Objects;

public class TruckParkingPlace extends AbstractParkingPlace {

    TypeOfVehicle typeOfVehicleParkingPlace = TypeOfVehicle.TRUCK;

    public TruckParkingPlace(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        overallParkingPlaceSize = size;
        availableParkingPlaceSize = size;
    }

    @Override
    public TypeOfVehicle getTypeOfVehicleParkingPlace() {
        return typeOfVehicleParkingPlace;
    }

    @Override
    public boolean isAvailableToParking(Vehicle vehicle) {
        if (vehicle.getSize() > 1 && availableParkingPlaceSize > 0) {
            availableParkingPlaceSize--;
            return true;
        }
        return false;
    }

    @Override
    public int setAvailableParkingPlaceSize(Vehicle vehicle) {
        return availableParkingPlaceSize--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TruckParkingPlace that = (TruckParkingPlace) o;
        return typeOfVehicleParkingPlace == that.typeOfVehicleParkingPlace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfVehicleParkingPlace);
    }

    @Override
    public String toString() {
        return "TruckParkingPlace{"
                + "typeOfVehicleParkingPlace=" + typeOfVehicleParkingPlace
                + ", vehicles=" + vehicles
                + ", overallParkingPlaceSize=" + overallParkingPlaceSize
                + ", availableParkingPlaceSize=" + availableParkingPlaceSize
                + '}';
    }
}
