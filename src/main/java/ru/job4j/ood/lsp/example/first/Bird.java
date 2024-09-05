package ru.job4j.ood.lsp.example.first;

/**
 * Инварианты.
 * Метод fly() позволяет птице летать. Созданный подкласс Penguin расширяет Bird.
 * При этом пингвины не летают, поэтому метод fly() для пингвина вызовет исключение,
 * что нарушает принцип Liskov Substitution Principle.
 * Метод fly() - должен содержать логику полёта.
 */
public class Bird {
    public void fly() {
    }
}
