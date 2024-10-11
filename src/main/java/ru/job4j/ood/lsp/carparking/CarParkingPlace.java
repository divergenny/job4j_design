package ru.job4j.ood.lsp.carparking;

public class CarParkingPlace extends AbstractParkingPlace {

    TypeOfVehicle typeOfVehicleParkingPlace = TypeOfVehicle.CAR;

    public CarParkingPlace(int size) {
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
        int sizeOfVehicle = vehicle.getSize();
        if (sizeOfVehicle == 1 && availableParkingPlaceSize > 0) {
            return true;
        } else if (sizeOfVehicle > 1
                && availableParkingPlaceSize > sizeOfVehicle) {
            return true;
        }
        return false;
    }

    @Override
    public int setAvailableParkingPlaceSize(Vehicle vehicle) {
        if (1 == vehicle.getSize()) {
            availableParkingPlaceSize = availableParkingPlaceSize - 1;
        } else {
            availableParkingPlaceSize = availableParkingPlaceSize - vehicle.getSize();
        }
        return availableParkingPlaceSize;
    }

    @Override
    public String toString() {
        return "CarParkingPlace{"
                + "typeOfVehicleParkingPlace=" + typeOfVehicleParkingPlace
                + ", vehicles=" + vehicles
                + ", overallParkingPlaceSize=" + overallParkingPlaceSize
                + ", availableParkingPlaceSize=" + availableParkingPlaceSize
                + '}';
    }
}
