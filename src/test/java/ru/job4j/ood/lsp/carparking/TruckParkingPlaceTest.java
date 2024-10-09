package ru.job4j.ood.lsp.carparking;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class TruckParkingPlaceTest {

    @Test
    void whenCheckIsAvailableToParkingTruckThenTrue() {
        ParkingPlace truckParkingPlace = new TruckParkingPlace(2);
        Vehicle firstTruckVehicle = new TruckVehicle("firstTruck", 2);
        assertThat(truckParkingPlace.isAvailableToParking(firstTruckVehicle)).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenCheckIsAvailableToParkingCarThenFalse() {
        ParkingPlace truckParkingPlace = new TruckParkingPlace(2);
        Vehicle firstCarVehicle = new CarVehicle("firstCar");
        assertThat(truckParkingPlace.isAvailableToParking(firstCarVehicle)).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenCheckIsAvailableToParkingTruckToFullParkingPlaceThenFalse() {
        ParkingPlace truckParkingPlace = new TruckParkingPlace(2);
        Vehicle firstTruckVehicle = new TruckVehicle("firstTruck", 2);
        Vehicle secondTruckVehicle = new TruckVehicle("secondTruck", 3);
        Vehicle thirdTruckVehicle = new TruckVehicle("thirdTruck", 3);
        truckParkingPlace.add(firstTruckVehicle);
        truckParkingPlace.add(secondTruckVehicle);
        assertThat(truckParkingPlace.isAvailableToParking(thirdTruckVehicle)).isEqualTo(Boolean.TRUE);
    }
}
