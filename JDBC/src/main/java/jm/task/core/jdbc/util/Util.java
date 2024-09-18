package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final Util INSTANCE = new Util();
    public static Connection connection;
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    private static final String URL_KEY = "db.url";

    private Util() {
    }

    public static Util getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                        PropertiesUtil.get(USERNAME_KEY),
                        PropertiesUtil.get(PASSWORD_KEY));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}