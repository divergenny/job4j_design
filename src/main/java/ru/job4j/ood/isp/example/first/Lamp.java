package ru.job4j.ood.isp.example.first;

public class Lamp implements Device {
    @Override
    public void turnOn() {
        System.out.println("Lamp is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Lamp is turned off");
    }

    @Override
    public void scanDocument(String document) {
        throw new Error("Not implemented");
    }

    @Override
    public void printDocument(String document) {
        throw new Error("Not implemented");
    }
}
