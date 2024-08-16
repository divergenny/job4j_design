package ru.job4j.ood.ocp.example.second;

/**
 * Если нужно добавить новый способ логирования,
 * например, отправку логов на удалённый сервер,
 * потребуется изменить класс Logger, добавив новый метод.
 * Это изменение исходного кода нарушает Open Closed Principle.
 * Метод logToConsole(String message) - должен содержать логику записи логов в консоль.
 * Метод logToFile(String message) - должен содержать логику записи логов в файл.
 */
public class Logger {
    public void logToConsole(String message) {
        System.out.println("Log to Console: " + message);
    }

    public void logToFile(String message) {
    }
}
