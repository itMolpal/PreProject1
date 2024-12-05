package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        // Создание пользователей

        userService.createUsersTable();
        userService.saveUser("Vitalii", "Sorokin", (byte) 25);
        userService.saveUser("Misha", "Voronin", (byte) 54);
        userService.saveUser("Oleg", "Govorov", (byte) 32);
        userService.saveUser("Anna", "Denisova", (byte) 19);
        userService.saveUser("Oleg", "Govorov", (byte) 32);

        userService.removeUserById(2);
        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
