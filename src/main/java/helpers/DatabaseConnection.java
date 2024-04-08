package helpers;

import models.ContactModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    public void contactDatabaseRecorder(String id, ContactModel contactModel) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/phonebook";
        String username = "root";
        String password = "Mari1981$";

        // Установка соединения с базой данных
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection successful!!!");
        /*Здесь используется метод DriverManager.getConnection(), чтобы установить соединение с базой данных.
        Мы передаем ему URL, имя пользователя и пароль для доступа к базе данных
         */
        // Формирование запроса на вставку данных

        String insertQuery = "INSERT INTO contacts(id, name, lastName, email, phone, " +
                "address, description)" + "VALUES (?,?,?,?,?,?,?)";

        /*ВАЖНЫЙ МОМЕНТ! INSERT INTO contacts(id, name, lastName, email, phone, address, description):
Это часть SQL-запроса, которая определяет, в какую таблицу (contacts) и какие столбцы
(id, name, lastName, email, phone, address, description) мы собираемся вставить данные.

    "VALUES (?,?,?,?,?,?,?)": Это вторая часть SQL-запроса, где мы указываем значения,
    которые мы хотим вставить в каждый из этих столбцов. Здесь вместо конкретных значений мы используем параметры-заполнители ?,
     которые будут заполнены реальными значениями при выполнении подготовленного запроса.

В итоге, данная строка представляет собой шаблон для SQL-запроса на вставку данных в таблицу contacts,
 где вместо конкретных значений мы будем использовать параметры-заполнители ?,
  чтобы избежать возможности SQL-инъекций и обеспечить безопасность операций с базой данных.*/

        /*
        Создается подготовленный запрос, и каждый параметр вставляется с помощью метода setString().
        Метод executeUpdate() выполняет запрос на обновление, и он возвращает количество измененных строк в базе данных.*/

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, contactModel.getName());
        preparedStatement.setString(3, contactModel.getLastName());
        preparedStatement.setString(4, contactModel.getEmail());
        preparedStatement.setString(5, contactModel.getPhone());
        preparedStatement.setString(6, contactModel.getAddress());
        preparedStatement.setString(7, contactModel.getDescription());

        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            System.out.println("Insert successful!");
        }else {
            System.out.println("Not succsessful...");
        }
        preparedStatement.close();
        connection.close();

    }
}
