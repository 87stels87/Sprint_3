import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateOrderTest extends BaseTest {
    @Test
    @DisplayName("Проверка создания заказа")
    @Description("") // о

    public void testCreateOrdersColorBlack() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(parametersOrderColorBlack)
                .when()
                .post("/api/v1/orders");
        response.then().assertThat().body("track", notNullValue()).and().statusCode(201);
    }

    @Test
    @DisplayName("Проверка создания заказа")
    @Description("") // о

    public void testCreateOrdersColorGray() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(parametersOrderColorGrey)
                .when()
                .post("/api/v1/orders");
        response.then().assertThat().body("track", notNullValue()).and().statusCode(201);
    }

    @Test
    @DisplayName("Проверка создания заказа")
    @Description("") // о

    public void testCreateOrdersColorGrayAndBlack() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(parametersOrderColorGreyAndBlack)
                .when()
                .post("/api/v1/orders");
        response.then().assertThat().body("track", notNullValue()).and().statusCode(201);
    }

    @Test
    @DisplayName("Проверка создания заказа")
    @Description("") // о

    public void testCreateOrdersWithoutColors() {
        Response response = given().contentType(ContentType.JSON)
              //  .header("Content-type", "application/json")
                .and()
                .body(parametersOrderWithoutColors)
                .when()
                .post("/api/v1/orders");
        response.then().assertThat().body("track", notNullValue()).and().statusCode(201);
    }


}
