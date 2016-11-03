package com.courses.spalah;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Roman on 29.10.2016.
 */
public class ConnectionManager {
    public java.sql.Connection getConnection () {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("E:/Java/resources/config.properties");
            property.load(fis);

            String host = property.getProperty("db.host");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");

            Connection connection = DriverManager.getConnection(host, login, password);
            return connection;
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        } catch (SQLException e) {
            System.err.println("ОШИБКА: Не удалось подключиться к БД!");
            e.printStackTrace();
        }
        return null;
    }
}
