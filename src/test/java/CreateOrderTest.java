import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateOrderTest extends BaseTest {

    @Test
    @DisplayName("Проверка создания заказа. Цвет = черный")
    @Description("Проверка создания заказа. Цвет = черный")

    public void testCreateOrdersColorBlack() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(PARAMETERS_ORDER_COLOR_BLACK)
                .when()
                .post(ORDER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("track", notNullValue())
                .and()
                .statusCode(201);
    }

    @Test
    @DisplayName("Проверка создания заказа. Цвет = серый")
    @Description("Проверка создания заказа. Цвет = серый")

    public void testCreateOrdersColorGray() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(PARAMETERS_ORDER_COLOR_GREY)
                .when()
                .post(ORDER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("track", notNullValue())
                .and()
                .statusCode(201);
    }

    @Test
    @DisplayName("Проверка создания заказа. Цвет серый и черный")
    @Description("Проверка создания заказа. Цвет серый и черный")

    public void testCreateOrdersColorGrayAndBlack() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(PARAMETERS_ORDER_COLOR_GREY_AND_BLACK)
                .when()
                .post(ORDER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("track", notNullValue())
                .and()
                .statusCode(201);
    }

    @Test
    @DisplayName("Проверка создания заказа без указания цвета")
    @Description("Проверка создания заказа без указания цвета")

    public void testCreateOrdersWithoutColors() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(PARAMETERS_ORDER_WITHOUT_COLORS)
                .when()
                .post(ORDER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("track", notNullValue())
                .and()
                .statusCode(201);
    }



}
