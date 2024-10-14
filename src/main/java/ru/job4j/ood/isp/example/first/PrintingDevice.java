package ru.job4j.ood.isp.example.first;

public class PrintingDevice implements Device {

    @Override
    public void turnOn() {
        System.out.println("Printer is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Printer is turned off");
    }

    @Override
    public void scanDocument(String document) {
        System.out.println("Printer is scanning document");
    }

    @Override
    public void printDocument(String document) {
        System.out.println("Printing document..");
    }
}
