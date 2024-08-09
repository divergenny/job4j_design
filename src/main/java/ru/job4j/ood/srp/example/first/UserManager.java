package ru.job4j.ood.srp.example.first;

/**
 * Класс UserManager несёт ответственность за управление пользователями и логирование,
 * что нарушает принцип единственной ответственности (SRP).
 * Решение: Создать логирование как отдельный класс.
 * class UserManager (createUser(String username, String password), deleteUser(String username))
 * и class Logger (log(String message) ).
 */
public class UserManager {
    public void createUser(String username, String password) {
        // Логика создания пользователя
        System.out.println("Пользователь создан: " + username);
    }

    public void deleteUser(String username) {
        // Логика удаления пользователя
        System.out.println("Пользователь удалён: " + username);
    }

    public void log(String message) {
        // Логика логирования сообщений
        System.out.println("Лог: " + message);
    }
}
