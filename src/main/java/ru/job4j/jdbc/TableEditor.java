package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public Connection getConnection() {
        return connection;
    }

    private void executeQuery(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        String url = properties.getProperty("database-url");
        String login = properties.getProperty("database-login");
        String password = properties.getProperty("database-password");
        String databaseDriver = properties.getProperty("database-driver");
        initConnection(url, login, password, databaseDriver);
    }

    private void initConnection(String url, String login, String password, String databaseDriver) throws SQLException, ClassNotFoundException {
        Class.forName(databaseDriver);
        this.connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) {
        String query = String.format(
                "create table if not exists %s();",
                tableName
        );
        executeQuery(query);
    }

    public void dropTable(String tableName) {
        String query = String.format(
                "drop table if exists %s;",
                tableName
        );
        executeQuery(query);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String query = String.format(
                "alter table if exists %s add column IF NOT EXISTS %s %s;",
                tableName,
                columnName,
                type
        );
        executeQuery(query);
    }

    public void dropColumn(String tableName, String columnName) {
        String query = String.format(
                "alter table if exists %s drop column %s;",
                tableName,
                columnName
        );
        executeQuery(query);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String query = String.format(
                "alter table if exists %s rename %s to %s;",
                tableName,
                columnName,
                newColumnName
        );
        executeQuery(query);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("./src/main/resources/app.properties")) {
            properties.load(inputStream);
            try (TableEditor editor = new TableEditor(properties)) {
                editor.createTable("vlad");
                System.out.println(getTableScheme(editor.getConnection(), "vlad"));
                editor.addColumn("vlad", "head_of_company", "varchar");
                editor.addColumn("vlad", "cars", "varchar");
                System.out.println(getTableScheme(editor.getConnection(), "vlad"));
                editor.dropColumn("vlad", "cars");
                System.out.println(getTableScheme(editor.getConnection(), "vlad"));
                editor.renameColumn("vlad", "head_of_company", "head_of_corporation");
                System.out.println(getTableScheme(editor.getConnection(), "vlad"));
                editor.dropTable("vlad");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
