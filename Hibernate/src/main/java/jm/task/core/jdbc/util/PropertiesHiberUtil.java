package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PropertiesHiberUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Создание конфигурации Hibernate
            Configuration configuration = new Configuration();

            // Установка параметров конфигурации
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgresSQLDialect"); // Укажите подходящий диалект
            configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // Автоматическое создание схемы
            configuration.setProperty("hibernate.show_sql", "true"); // Показывать SQL
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver"); // Укажите драйвер
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres"); // URL вашей базы данных
            configuration.setProperty("hibernate.connection.username", "postgres"); // Имя пользователя
            configuration.setProperty("hibernate.connection.password", "12345678"); // Пароль

            // Добавление классов сущностей
            configuration.addAnnotatedClass(User.class); // Добавьте сюда свои сущности

            // Создание ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // Создание SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Закрытие кэша и пула соединений
        getSessionFactory().close();
    }
}