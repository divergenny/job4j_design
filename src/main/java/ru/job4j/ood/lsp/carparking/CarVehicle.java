package ru.job4j.ood.lsp.carparking;

public class CarVehicle extends AbstractVehicle {
    String model;

    final int size = 1;

    public CarVehicle(String model) {
        this.model = model;
    }

    @Override
    public TypeOfVehicle getTypeOfVehicle() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
