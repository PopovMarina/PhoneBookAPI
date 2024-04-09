//package restassured;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import models.AuthenticationRequestModel;
//import models.AuthenticationResponseModel;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//
//public class LoginTest {
//
//    @Test
//    public void loginTestRestAssured() {
//        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
//
//        AuthenticationRequestModel authenticationRequestModel =
//                AuthenticationRequestModel.userName("poi7777@mail.rud").password("Aa12345$");
//
//        AuthenticationResponseModel response = given()
//                .body(authenticationRequestModel).contentType(ContentType.JSON)
//                .when()
//                .post().then().log().all().assertThat().statusCode(200)
//                .extract()
//                .as(AuthenticationResponseModel.class);
//
//        System.out.println("Token : " + response.getToken());
//
//    }
//}
package restassured;

import helpers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.AuthenticationRequestModel;
import models.AuthenticationResponseModel;
import models.ContactModel;
import models.NewUserModel;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest implements TestHelper {
@Test
    public void registrationTest() {
        NewUserModel newUserModel = new NewUserModel("kyuj65h9gk588@hjvc.com", "asdQWE153!");
                /*NewUserModel(EmailGenerator.generateEmail(7,7,3)
                , PasswordStringGenerator.generateString());
                 */

        String token = given().body(newUserModel).contentType(ContentType.JSON)
                .when()
                .post("https://contactapp-telran-backend.herokuapp.com/v1/user/registration/usernamepassword")
                .then().assertThat().statusCode(200)
                .extract().path("token");

    PropertiesWritter.writeProperties("token", token);

        System.out.println("Token: " + token);
    }

    @Test
    public void loginTestRestAssured(){
        RestAssured.baseURI = LOGIN_PATH;

        AuthenticationRequestModel authenticationRequestModel =
                AuthenticationRequestModel.userName("poikhaf770@mail.rud").password("Aa1234567$");

        AuthenticationResponseModel response = given()
                .body(authenticationRequestModel)
                .contentType(ContentType.JSON)
                .when()
                .post().then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(AuthenticationResponseModel.class);
        PropertiesWritter.writeProperties("token",response.getToken());

        System.out.println("Token : " + response.getToken());

    }

//    RestAssured.baseURI = LOGIN_PATH;
//        //RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
//        //  RestAssured.baseURI = BASE_URL (только базовый URL; RestAssured.basePath = \v1\ser...(хвостик - конечная точка)
//
//        AuthenticationRequestModel authenticationRequestModel =
//                AuthenticationRequestModel.userName("kyuj65h9gk588@hjvc.com").password("asdQWE153!");
//
//        AuthenticationResponseModel response = given()
//                .body(authenticationRequestModel)
//                .contentType(ContentType.JSON)
//                .when()
//                .post().then().log().all()
//                .assertThat()
//                .statusCode(200)
//                .extract()
//                .as(AuthenticationResponseModel.class);
//
//        PropertiesWritter.writeProperties("token", response.getToken());
//
//        System.out.println("Token : " + response.getToken());
//    }

}
