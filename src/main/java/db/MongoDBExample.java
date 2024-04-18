package db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.ContactModel;
import org.bson.Document;


public class MongoDBExample {
    public static void main(String[] args) {
        addNewEntity();
    }

    public static void addNewEntity() {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://pilgrim74:Mari8888@cluster0.wtwpova.mongodb.net/");
       // MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//MongoClients.create(): Это статический метод, который используется для создания
// экземпляра MongoClient. Он принимает строку подключения в качестве аргумента.
// "mongodb://localhost:27017": Это строка подключения к серверу MongoDB.
// В данном случае, "mongodb://localhost:27017" указывает на то, что MongoDB сервер
// запущен на локальном хосте (localhost) и слушает порт 27017, который является
// портом по умолчанию для MongoDB.

//MongoClient: Это класс из Java MongoDB driver, который представляет собой точку входа
// для подключения к MongoDB серверу. Он обеспечивает методы для работы с базами данных,
// коллекциями и выполнения операций в MongoDB.
        MongoDatabase database = mongoClient.getDatabase("test");

        MongoCollection<Document> collection = database.getCollection("mycollection");

        Document document = new Document("name","Alice").append("Age", 25)
                .append("email", EmailGenerator.generateEmail(5,5,3));

        /*ContactModel contactModel = new ContactModel(NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                EmailGenerator.generateEmail(5,5,3),
                PhoneNumberGenerator.generatePhoneNumber(),
                AddressGenerator.generateAddress(),
                "description");

         */

    //    Document document1 = new Document("contact", contactModel);

        collection.insertOne(document);
      //  collection.insertOne(document1);

    }


}
