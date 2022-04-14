import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTest extends BaseTest {

    @Test
    @DisplayName("Проверка авторизации курьера с паролем,именем и логином")
    @Description("Проверка авторизации курьера с паролем,именем и логином")
    public void testLoginCourierWithLoginPasswordFirstName() {
        given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(courierRandomLoginPasswordFirstName)
                .when().log().all()
                .post(COURIER_CREATE_PATH);
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(courierRandomLoginPasswordFirstName)
                .when()
                .post(COURIER_LOGIN_PATH);
        response.then()
                .assertThat()
                .body("id", notNullValue())
                .and().log().all()
                .statusCode(HTTP_OK);
    }

   @Test
    @DisplayName("Проверка логина курьера без указания логина")
    @Description("Проверка логина курьера без указания логина")
    public void testLoginCourierWithoutLogin() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(courierRandomPasswordFirstName)
                .when()
                .post(COURIER_LOGIN_PATH);
       response.then()
               .assertThat()
               .body("message", equalTo("Недостаточно данных для входа"))
               .and()
               .statusCode(HTTP_BAD_REQUEST);
   }

    @Test
    @DisplayName("Проверка авторизации курьера с паролем и логином")
    @Description("Проверка авторизации курьера с паролем и логином")
    public void testLoginCourierWithLoginPassword() {
        given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(courierRandomLoginPassword)
                .when().log().all()
                .post(COURIER_CREATE_PATH);
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(courierRandomLoginPassword)
                .when()
                .post(COURIER_LOGIN_PATH);
        response.then()
                .assertThat()
                .body("id", notNullValue())
                .and().log().all()
                .statusCode(HTTP_OK);
    }

    @Test
    @DisplayName("Проверка логина курьера  с несуществующим логином")
    @Description("Проверка логина курьера  с несуществующим логином")
    public void testLoginCourierNonExistentLogin() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(courierRandomLoginPasswordFirstName)
                .when()
                .post(COURIER_LOGIN_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Учетная запись не найдена"))
                .and()
                .statusCode(HTTP_NOT_FOUND);
    }
}
