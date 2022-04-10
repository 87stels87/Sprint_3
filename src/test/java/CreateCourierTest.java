import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class CreateCourierTest extends BaseTest {


    @Test
    @DisplayName("Проверка создания нового курьера") // имя теста
    @Description("Тест проверяет создание нового курьера со всеми валидными параметрами") // о
    public void testCreateNewCourier() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBody)
                .when()
                .post("/api/v1/courier");
        response.then().assertThat().body("ok", equalTo(true))
                .and().statusCode(201);
    }

    @Test
    @DisplayName("Провера создания курьера с уже существующим логином") // имя теста
    @Description("Тест проверяет, что новый курьер не создастся при повторном логине") // о
    public void testCreateIdentialCourier() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBody)
                .when()
                .post("/api/v1/courier");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBody)
                .when()
                .post("/api/v1/courier");
        response.then().assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."))
                .and().statusCode(409);

    }

    @Test
    @DisplayName("Провера создания курьера без обязательного параметра Логин") // имя теста
    @Description("Тест проверяет, что новый курьер не создастся без параметра Логин") //
    public void testCreateNewCourierWithoutLogin() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBodyWithoutLogin)
                .when()
                .post("/api/v1/courier");
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and().statusCode(400);
    }

    @Test
    @DisplayName("Провера создания курьера без обязательного параметра Пароль") // имя теста
    @Description("Тест проверяет, что новый курьер не создастся без параметра Пароль")
    public void testCreateNewCourierWithoutPassword() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBodyWithoutPassword)
                .when()
                .post("/api/v1/courier");
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and().statusCode(400);
    }

    @Test
    @DisplayName("Провера создания курьера без обязательного параметров Логин и Пароль") // имя теста
    @Description("Тест проверяет, что новый курьер не создастся без параметров Логин и Пароль")
    public void testCreateNewCourierWithoutPasswordAndLogin() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBodyWithoutPasswordAndLogin)
                .when()
                .post("/api/v1/courier");
        response.then().assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and().statusCode(400);
    }

}

