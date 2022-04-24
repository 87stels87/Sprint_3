import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.notNullValue;

public class TestGetOrderList extends BaseTest {
    @Test
    @DisplayName("Получение списка созданных заказов")
    @Description("Получение списка созданных заказов")

    public void testGetOrderList() {
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .get(ORDER_CREATE_PATH);
        response.then()
                .assertThat()
                .body("orders", notNullValue())
                .and()
                .statusCode(HTTP_OK);
    }
}
