import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTest extends BaseTest {

    @Test
    @DisplayName("Проверка авторизации курьера")
    @Description("Проверка авторизации курьера")
    public void testLoginCourier() {
        given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY)
                .when()
                .post(COURIER_CREATE_PATH);
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY)
                .when()
                .post(COURIER_LOGIN_PATH);
        response.then()
                .assertThat()
                .body("id", notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка логина курьера без указания пароля")
    @Description("Проверка логина курьера без указания пароля")
    public void testLoginCourierWithoutPassword() {

        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(LOGIN_REQUEST_BODY_WITHOUT_PASSWORD)
                .when()
                .post(COURIER_LOGIN_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }

    @Test
    @DisplayName("Проверка логина курьера без указания логина")
    @Description("Проверка логина курьера без указания логина")
    public void testLoginCourierWithoutLogin() {

        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(LOGIN_REQUEST_BODY_WITHOUT_LOGIN)
                .when()
                .post(COURIER_LOGIN_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }

    @Test
    @DisplayName("Проверка логина курьера  с несуществующим логином")
    @Description("Проверка логина курьера  с несуществующим логином")
    public void testLoginCourierNonExistentLogin() {

        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY_WITHOUT_FIRST_NAME)
                .when()
                .post(COURIER_LOGIN_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Учетная запись не найдена"))
                .and()
                .statusCode(404);
    }
}
