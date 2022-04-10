import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class DeleteCourierTest extends BaseTest {
    @Test
    @DisplayName("Проверка логина курьера") // имя теста
    @Description("Тест сначала создает нового курьера, а затем проверяет корректный логин курьера в приложении") // о

    public void testDeleteCourier() {
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

        int a1 = response.body().path("id");
        System.out.println(a1);
        given()
                .header("Content-type", "application/json")
                .when()
                .delete("/api/v1/courier/"+a1);


    }
}
