package com.courses.spalah;

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
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/config.properties"));

            String host = properties.getProperty("db.host");
            String login = properties.getProperty("db.login");
            String password = properties.getProperty("db.password");

            Connection con = DriverManager.getConnection(host, login, password);
            return con;
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        } catch (SQLException e) {
            System.err.println("ОШИБКА: Не удалось подключиться к БД!");
            e.printStackTrace();
        }
        return null;
    }
}
