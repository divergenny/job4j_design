package ru.job4j.ood.lsp.carparking;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class CarParkingPlaceTest {
    @Test
    void whenCheckIsAvailableToParkingCarThenTrue() {
        ParkingPlace carParkingPlace = new CarParkingPlace(4);
        Vehicle firstCarVehicle = new CarVehicle("firstCar");
        assertThat(carParkingPlace.isAvailableToParking(firstCarVehicle)).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenCheckIsAvailableToParkingTruckThenTrue() {
        ParkingPlace carParkingPlace = new CarParkingPlace(4);
        Vehicle firstCarVehicle = new CarVehicle("firstCar");
        carParkingPlace.add(firstCarVehicle);
        Vehicle firstTruckVehicle = new TruckVehicle("firstTruck", 2);
        assertThat(carParkingPlace.isAvailableToParking(firstTruckVehicle)).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenCheckIsAvailableToParkingTruckToFullParkingPlaceThenFalse() {
        ParkingPlace carParkingPlace = new CarParkingPlace(4);
        Vehicle firstCarVehicle = new CarVehicle("firstCar");
        Vehicle firstTruckVehicle = new TruckVehicle("secondTruck", 3);
        Vehicle secondTruckVehicle = new TruckVehicle("thirdTruck", 3);
        carParkingPlace.add(firstCarVehicle);
        carParkingPlace.add(firstTruckVehicle);
        assertThat(carParkingPlace.isAvailableToParking(secondTruckVehicle)).isEqualTo(Boolean.FALSE);
    }
}
