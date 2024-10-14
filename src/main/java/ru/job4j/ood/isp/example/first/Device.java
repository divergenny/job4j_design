package ru.job4j.ood.isp.example.first;

/**
 * Интерфейс Device включает методы для работы с функциями сканирования и печати.
 * Если устройство является просто лампой, оно не должно иметь функционала сканирования и печати.
 * При этом класс Lamp будет вынужден реализовать ненужные методы,
 * что нарушает принцип разделения интерфейсов (Interface Segregation Principle).
 */
public interface Device {
    void turnOn();

    void turnOff();

    void scanDocument(String document);

    void printDocument(String document);
}
