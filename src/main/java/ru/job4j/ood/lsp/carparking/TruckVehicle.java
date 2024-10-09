package ru.job4j.ood.lsp.carparking;

public class TruckVehicle extends AbstractVehicle {
    String model;
    int size;

    public TruckVehicle(String model, int size) {
        this.model = model;
        this.size = size;
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
