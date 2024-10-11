package ru.job4j.ood.lsp.carparking;

import java.util.ArrayList;
import java.util.List;

public class ControlParkingPlace {

    List<ParkingPlace> carParkingPlaces = new ArrayList<>();
    List<ParkingPlace> truckParkingPlaces = new ArrayList<>();

    public ControlParkingPlace(List<ParkingPlace> parkingPlaces) {
        sortParkingPlacesByType(parkingPlaces);
    }

    private void sortParkingPlacesByType(List<ParkingPlace> parkingPlaces) {
        for (ParkingPlace parkingPlace : parkingPlaces) {
            if (parkingPlace.getTypeOfVehicleParkingPlace() == TypeOfVehicle.CAR) {
                carParkingPlaces.add(parkingPlace);
            } else {
                truckParkingPlaces.add(parkingPlace);
            }
        }
    }

    public boolean sortToParkingPlace(Vehicle vehicle) {
        boolean flagAdded = false;
        if (vehicle.getSize() > 1) {
            for (ParkingPlace parkingPlace : truckParkingPlaces) {
                flagAdded = parkingPlace.addVehicleToSpecificParkingPlace(vehicle);
                if (flagAdded) {
                    return true;
                }
            }
        }
        if (!flagAdded) {
            for (ParkingPlace parkingPlace : carParkingPlaces) {
                flagAdded = parkingPlace.addVehicleToSpecificParkingPlace(vehicle);
                if (flagAdded) {
                    return true;
                }
            }
        }
        return flagAdded;
    }
}
