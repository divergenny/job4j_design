package ru.job4j.ood.dip.example.first;

/**
 * Класс UserService зависит от конкретной реализации базы данных MySQLDatabase,
 * а не от абстракции интерфейса. Если нужно будет поменять базу данных, придется изменить код UserService,
 * что нарушает принцип инверсии зависимости (Dependency Inversion Principle).
 */
public class UserService {
    private MySQLDatabase database;

    public UserService() {
        this.database = new MySQLDatabase();
    }

    public void getUserData() {
        database.connect();
        System.out.println("Fetching user data from MySQL...");
    }
}
