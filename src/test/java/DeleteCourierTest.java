import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCourierTest extends BaseTest {

    @Test
    @DisplayName("Проверка удаления курьера")
    @Description("Проверка удаления курьера")

    public void testDeleteCourier() {
        //создаем нового курьера
        given()
                .spec(RestAssuredClient.getBaseSpec())
                .body(REGISTER_REQUEST_BODY)
                .when()
                .post(COURIER_CREATE_PATH);
        //получаем id созданного курьера
        Response response =
                given()
                        .spec(RestAssuredClient.getBaseSpec())
                        .body(REGISTER_REQUEST_BODY)
                        .when()
                        .post(COURIER_LOGIN_PATH);
        response.then()
                .extract()
                .path("id");

        //подставляем id в метод delete
        int idCourier = response.body().path("id");
        Response response1 =
                given()
                        .spec(RestAssuredClient.getBaseSpec())
                        .when()
                        .body("{\"id\":\"" + idCourier + "\"}")
                        .delete(COURIER_CREATE_PATH + idCourier);
        response1.then()
                .assertThat()
                .body("ok", equalTo(true))
                .and()
                .statusCode(200);
    }

    @Test
    public void testDeleteNotDoneIdCourier() {
        int idCourier = 0;
        Response response = given()
                .spec(RestAssuredClient.getBaseSpec())
                .body("{\"id\":\"" + idCourier + "\"}")
                .delete(COURIER_CREATE_PATH + idCourier);
        response
                .then()
                .assertThat()
                .body("message", equalTo("Курьера с таким id нет."))
                .and()
                .statusCode(404);
    }


}
