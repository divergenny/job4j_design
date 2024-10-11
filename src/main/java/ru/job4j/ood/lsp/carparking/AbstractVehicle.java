package ru.job4j.ood.lsp.carparking;

import java.util.Objects;

public abstract class AbstractVehicle implements Vehicle {
    protected int sizeOfVehicle;

    protected String model;


    public AbstractVehicle(String model, int sizeOfVehicle) {
        this.model = model;
        this.sizeOfVehicle = sizeOfVehicle;
    }

    public AbstractVehicle(String model) {
        this.model = model;
    }


    public AbstractVehicle() {
    }

    @Override
    public int getSize() {
        return sizeOfVehicle;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractVehicle that = (AbstractVehicle) o;
        return sizeOfVehicle == that.sizeOfVehicle && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeOfVehicle, model);
    }

    @Override
    public String toString() {
        return "AbstractVehicle{"
                + "sizeOfVehicle=" + sizeOfVehicle
                + ", model='" + model + '\''
                + '}';
    }
}
