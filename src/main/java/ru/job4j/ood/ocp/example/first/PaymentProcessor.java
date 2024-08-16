package ru.job4j.ood.ocp.example.first;

/**
 * Если необходимо добавить новый способ оплаты,
 * например, Click или Payme, придётся изменить код класса PaymentProcessor,
 * добавив новый метод для обработки платежей.
 * Это требует модификации существующего класса, что нарушает Open Closed Principle.
 * Метод processCreditCardPayment(double amount) - должен содержать логику обработки платежа через кредитную карту.
 * Метод processPayPalPayment(double amount) - должен содержать логику обработки платежа через PayPal.
 */
public class PaymentProcessor {
    public void processCreditCardPayment(double amount) {
    }

    public void processPayPalPayment(double amount) {
    }
}
