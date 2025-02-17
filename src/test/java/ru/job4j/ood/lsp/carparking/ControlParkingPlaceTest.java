package ru.job4j.ood.lsp.carparking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ControlParkingPlaceTest {
    List<ParkingPlace> parkingPlaces;
    ParkingPlace underCheryomushkaCarParking;
    ParkingPlace underCheryomushkaTruckParking;
    Vehicle nexiaCar;
    Vehicle sparkCar;
    Vehicle belazTruck;
    Vehicle fargoTruck;
    ControlParkingPlace controlUnderCheryomushkaParkingPlace;

    @BeforeEach
    public void initEach() throws Exception {
        parkingPlaces = new ArrayList<>();
        underCheryomushkaCarParking = new CarParkingPlace(5);
        underCheryomushkaTruckParking = new TruckParkingPlace(2);
        parkingPlaces.add(underCheryomushkaCarParking);
        parkingPlaces.add(underCheryomushkaTruckParking);
        nexiaCar = new CarVehicle("Nexia 3");
        sparkCar = new CarVehicle("Spark 2");
        belazTruck = new TruckVehicle("BelAZ", 2);
        fargoTruck = new TruckVehicle("Fargo", 3);
    }

    @Test
    void whenCheckSortOfCar() {
        controlUnderCheryomushkaParkingPlace = new ControlParkingPlace(parkingPlaces);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(nexiaCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(sparkCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(belazTruck);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(fargoTruck);
        List<Vehicle> expected = List.of(nexiaCar, sparkCar);
        assertThat(underCheryomushkaCarParking.findAll()).isEqualTo(expected);
    }

    @Test
    void whenCheckSortOfTruck() {
        controlUnderCheryomushkaParkingPlace = new ControlParkingPlace(parkingPlaces);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(nexiaCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(sparkCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(belazTruck);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(fargoTruck);
        List<Vehicle> expected = List.of(belazTruck, fargoTruck);
        assertThat(underCheryomushkaTruckParking.findAll()).isEqualTo(expected);
    }

    @Test
    void whenTruckParkingFullAndSortTruckOnCarParking() {
        controlUnderCheryomushkaParkingPlace = new ControlParkingPlace(parkingPlaces);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(nexiaCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(sparkCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(belazTruck);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(fargoTruck);
        Vehicle uralTruck = new TruckVehicle("Ural", 2);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(uralTruck);
        List<Vehicle> expected = List.of(nexiaCar, sparkCar, uralTruck);
        assertThat(underCheryomushkaCarParking.findAll()).isEqualTo(expected);
    }

    @Test
    void whenSortTruckOnCarParkingAndNoPlace() {
        controlUnderCheryomushkaParkingPlace = new ControlParkingPlace(parkingPlaces);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(nexiaCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(sparkCar);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(belazTruck);
        controlUnderCheryomushkaParkingPlace.sortToParkingPlace(fargoTruck);
        Vehicle uralTruck = new TruckVehicle("Ural", 5);
        assertThat(controlUnderCheryomushkaParkingPlace.sortToParkingPlace(uralTruck)).isEqualTo(Boolean.FALSE);
    }
}
