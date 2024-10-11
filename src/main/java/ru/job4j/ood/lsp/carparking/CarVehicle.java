package ru.job4j.ood.lsp.carparking;

import java.util.Objects;

public class CarVehicle extends AbstractVehicle {
    final int sizeOfVehicle = 1;

    public CarVehicle(String model) {
        super(model);
    }

    @Override
    public int getSize() {
        return sizeOfVehicle;
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
        CarVehicle that = (CarVehicle) o;
        return sizeOfVehicle == that.sizeOfVehicle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sizeOfVehicle);
    }

    @Override
    public String toString() {
        return "CarVehicle{"
                + "sizeOfVehicle=" + sizeOfVehicle
                + ", model='" + model + '\''
                + '}';
    }
}
