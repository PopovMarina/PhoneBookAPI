package helpers;

import models.ContactModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DateBaseReader {
    static String url = "jdbc:mysql://localhost:3306/phonebook";
    static String username = "root";
    static String password = "Mari1981$";

    public static ContactModel readContactFromDateBase(String id) throws SQLException {
        ContactModel contactModel = null;

        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println("Connection successful!");
        String query = "Select * From contacts where id= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            contactModel = new ContactModel();
            contactModel.setId(resultSet.getString("id"));
            contactModel.setName(resultSet.getString("name"));
            contactModel.setLastName(resultSet.getString("lastname"));
            contactModel.setEmail(resultSet.getString("email"));
            contactModel.setPhone(resultSet.getString("phone"));
            contactModel.setPhone(resultSet.getString("address"));
            contactModel.setDescription(resultSet.getString("description"));
        }
        else {
            System.out.println("No contact found using id " + id);
        }

        preparedStatement.close();
        connection.close();
        return contactModel;

    }

    ///////////////////////////////////
    public static List<ContactModel> readAllContactFromDateBase() throws SQLException {
        List<ContactModel> contacts = new ArrayList<>();

        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println("Connection successful!");
        String query = "Select * From contacts";

        Statement statement = connection.createStatement();
        //Statement гораздо более безопасный запрос в БД = тяжелее перехватить,
        //чем PreparedStatement

        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            ContactModel contactModel = new ContactModel();

            contactModel.setId(resultSet.getString("id"));
            contactModel.setName(resultSet.getString("name"));
            contactModel.setLastName(resultSet.getString("lastname"));
            contactModel.setEmail(resultSet.getString("email"));
            contactModel.setPhone(resultSet.getString("phone"));
            contactModel.setPhone(resultSet.getString("address"));
            contacts.add(contactModel);
        }

        statement.close();
        connection.close();
        return contacts;

    }

    public static void main(String[] args) throws SQLException {

        ContactModel contact = readContactFromDateBase("46bf141b-2f48-408a-880b-71baa2b32519");
        System.out.println("Contact name: " + contact.getName());
        System.out.println("An email: " + contact.getEmail());


        List <ContactModel> cont = readAllContactFromDateBase();
        for (ContactModel contactModel : cont) {
            System.out.println("Record: " + contactModel.toString());
        }

    }
}
