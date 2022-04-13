import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateCourierTest extends BaseTest {

    @Test
    @DisplayName("Проверка создания нового курьера")
    @Description("Проверка создания нового курьера")

    public void testCreateNewCourier() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY)
                .when()
                .post(COURIER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("ok", equalTo(true))
                .and()
                .statusCode(201);
    }

    @Test
    @DisplayName("Провера создания курьера с уже существующим логином")
    @Description("Провера создания курьера с уже существующим логином")

    public void testCreateIdentialCourier() {
        given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY)
                .when()
                .post(COURIER_CREATE_PATH);
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY)
                .when()
                .post(COURIER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."))
                .and()
                .statusCode(409);
    }

    @Test
    @DisplayName("Провера создания курьера без обязательного параметра Логин")
    @Description("Провера создания курьера без обязательного параметра Логин")

    public void testCreateNewCourierWithoutLogin() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY_WITHOUT_LOGIN)
                .when()
                .post(COURIER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }

    @Test
    @DisplayName("Провера создания курьера без обязательного параметра Пароль")
    @Description("Провера создания курьера без обязательного параметра Пароль")

    public void testCreateNewCourierWithoutPassword() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY_WITHOUT_PASSWORD)
                .when()
                .post(COURIER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }

    @Test
    @DisplayName("Провера создания курьера без обязательного параметров Логин и Пароль")
    @Description("Провера создания курьера без обязательного параметров Логин и Пароль")

    public void testCreateNewCourierWithoutPasswordAndLogin() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY_WITHOUT_PASSWORD_AND_LOGIN)
                .when()
                .post(COURIER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }
}

