package ru.job4j.ood.lsp.example.first;

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}
