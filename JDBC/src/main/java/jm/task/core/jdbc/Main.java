package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        userService.createUsersTable();
        userService.saveUser("Vitalii", "Sorokin", (byte) 25);
        userService.saveUser("Misha", "Voronin", (byte) 54);
        userService.saveUser("Oleg", "Govorov", (byte) 32);
        userService.saveUser("Anna", "Denisova", (byte) 19);
//        userService.removeUserById(2);
        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();




    }
}
