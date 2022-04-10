import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTest extends BaseTest {

    @Test
    @DisplayName("Проверка логина курьера") // имя теста
    @Description("Тест сначала создает нового курьера, а затем проверяет корректный логин курьера в приложении") // о

    public void testLoginCourier() {
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
                .post("/api/v1/courier/login");
        response.then().assertThat().body("id", notNullValue()).and().statusCode(200).extract().path("id");
        int a = response.body().path("id");

    }

    @Test
    @DisplayName("Проверка логина курьера без указания пароля в JSON") // имя теста
    @Description("Тест проверяет возможность логина в приложении без пароля")
    public void testLoginCourierWithoutPassword() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(loginRequestBodyWithoutPassword)
                .when()
                .post("/api/v1/courier/login");
        response.then().assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .and().statusCode(400);
    }

    @Test
    @DisplayName("Проверка логина курьера без указания логина в JSON")
    @Description("Тест проверяет возможность логина в приложении без логина")
    public void testLoginCourierWithoutLogin() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(loginRequestBodyWithoutLogin)
                .when()
                .post("/api/v1/courier/login");
        response.then().assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .and().statusCode(400);

    }

    @Test
    @DisplayName("Проверка логина курьера  с только что сгенерированным новым логином")
    @Description("Тест проверяет возможность логина в приложении с незарегистрированным логином")
    public void testLoginCourierNonexistentLogin() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(registerRequestBody)
                .when()
                .post("/api/v1/courier/login");
        response.then().assertThat().body("message", equalTo("Учетная запись не найдена")).
                and().statusCode(404);

    }
}
