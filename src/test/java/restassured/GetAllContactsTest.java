package restassured;

import helpers.PropertiesReader;
import helpers.TestHelper;
import io.restassured.http.ContentType;
import models.AuthenticationRequestModel;
import models.ContactListModel;
import models.ContactModel;
import models.ErrorModel;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class GetAllContactsTest implements TestHelper {

    @Test
    public void getAllContactsPositive() throws IOException {

        File logFile = new File("src/logs/testresult.log");
        if(!logFile.exists()) {
            logFile.getParentFile().mkdir();
            logFile.createNewFile();
        }
        PrintStream printStream = new PrintStream(new FileOutputStream(logFile));
        System.setOut(printStream);
        System.setErr(printStream);


            ContactListModel contactList = given()
                .header(AuthorizationHeader, PropertiesReader.getProperty("token"))
                .when()
                .get(PropertiesReader.getProperty("getAllContacts"))
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(ContactListModel.class);

        for(ContactModel contact : contactList.getContacts()) {
            System.out.println(contact.getEmail());
            System.out.println(contact.getId());
            System.out.println("+++++++++++++++++++++++++++++++++++");
        }

    printStream.close();

    }

 @Test
 public void loginNegative() {
     AuthenticationRequestModel authenticationRequestModel =
             AuthenticationRequestModel.userName("hghfhjggfgom").password("jhj453!");

     ErrorModel errorModel = given().
             body(authenticationRequestModel)
             .contentType(ContentType.JSON)
             .when()
             //.post("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
             .post(LOGIN_PATH)
             .then().log().all()
             .assertThat()
             .statusCode(401).extract().as(ErrorModel.class);

     System.out.println(errorModel.getError() + " : " + errorModel.getMessage());

 }
}
