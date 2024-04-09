package restassured;

import helpers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.ContactModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class UpdateAndDeleteContactTest implements TestHelper {
    ContactModel contactModel;
    String id;

    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = ADDCONTACT_PATH;
        contactModel = new ContactModel(NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                EmailGenerator.generateEmail(5,5,3),
                PhoneNumberGenerator.generatePhoneNumber(),
                AddressGenerator.generateAddress(),
                "description");

        String message = given().header(AuthorizationHeader, PropertiesReader.getProperty("token"))
                .body(contactModel)
                .contentType(ContentType.JSON)
                .when().post().then()
                .assertThat().statusCode(200)
                .extract().path("message");

        System.out.println("STRING : " + message);
        id = IdExtractor.extractId(message);
    }

    @Test
    public void updateContactTest() {
        contactModel.setId(id);
        contactModel.setEmail(EmailGenerator.generateEmail(5,5,3));

        given().header(AuthorizationHeader, PropertiesReader.getProperty("token"))
                .body(contactModel).contentType(ContentType.JSON)
                .when().put().then().assertThat().statusCode(200)
                .assertThat().body("message", containsString("updated"));

    }

    @Test
    public void deleteContactById() {
        given().header(AuthorizationHeader,PropertiesReader.getProperty("token"))
                .when().delete(id).then().assertThat().statusCode(200)
                .assertThat().body("message", containsString("deleted"));

    }

}
//ДЗ сравнить два контакта по мэйлу и записать