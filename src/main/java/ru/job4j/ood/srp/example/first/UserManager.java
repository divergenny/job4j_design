package ru.job4j.ood.srp.example.first;

/**
 * Класс UserManager несёт ответственность за управление пользователями и логирование,
 * что нарушает принцип единственной ответственности (SRP).
 * Решение: Создать логирование как отдельный класс.
 * class UserManager (createUser(String username, String password), deleteUser(String username))
 * и class Logger (log(String message) ).
 * Метод createUser(String username, String password) - должен содержать логику создания пользователя.
 * Метод deleteUser(String username) - должен содержать логику удаления пользователя.
 * Метод log(String message) - должен содержать логику логирования сообщений.
 */
public class UserManager {
    public void createUser(String username, String password) {
        System.out.println("Пользователь создан: " + username);
    }

    public void deleteUser(String username) {
        System.out.println("Пользователь удалён: " + username);
    }

    public void log(String message) {
        System.out.println("Лог: " + message);
    }
}
