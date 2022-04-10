import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;

public class BaseTest {
    String courierLogin = RandomStringUtils.randomAlphabetic(10);
    String courierPassword = RandomStringUtils.randomAlphabetic(10);
    String courierFirstName = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    String registerRequestBody =
            "{\"login\":\"" + courierLogin + "\","
                    + "\"password\":\"" + courierPassword + "\","
                    + "\"firstName\":\"" + courierFirstName + "\"}";

    String registerRequestBodyWithoutPasswordAndLogin =
            "{\"firstName\":\"" + courierFirstName + "\"}";

    String registerRequestBodyWithoutPassword =
            "{\"login\":\"" + courierLogin + "\","
                    + "\"firstName\":\"" + courierFirstName + "\"}";
    String registerRequestBodyWithoutLogin =
            "{\"password\":\"" + courierPassword + "\","
                    + "\"firstName\":\"" + courierFirstName + "\"}";

    String registerRequestBodyWithoutFirstName =
            "{\"login\":\"" + courierLogin + "\","
                    + "\"password\":\"" + courierPassword + "\",}";

    String loginRequestBodyWithoutLogin =
            "{\"login\":\"\",\"password\":\"" + courierPassword + "\"}";

    String loginRequestBodyWithoutPassword =
            "{\"login\":\"" + courierLogin + "\"," + "\"password\":\"\"}";


    String parametersOrderColorBlack =
            "{\n" +
                    "    \"firstName\": \"Naruto\",\n" +
                    "    \"lastName\": \"Uchiha\",\n" +
                    "    \"address\": \"Konoha, 142 apt.\",\n" +
                    "    \"metroStation\": 4,\n" +
                    "    \"phone\": \"+7 800 355 35 35\",\n" +
                    "    \"rentTime\": 5,\n" +
                    "    \"deliveryDate\": \"2020-06-06\",\n" +
                    "    \"comment\": \"Saske, come back to Konoha\",\n" +
                    "    \"color\": [\n" +
                    "        \"BLACK\"\n" +
                    "    ]\n" +
                    "}";



    String parametersOrderColorGrey =
            "{\n" +
                    "    \"firstName\": \"Naruto\",\n" +
                    "    \"lastName\": \"Uchiha\",\n" +
                    "    \"address\": \"Konoha, 142 apt.\",\n" +
                    "    \"metroStation\": 4,\n" +
                    "    \"phone\": \"+7 800 355 35 35\",\n" +
                    "    \"rentTime\": 5,\n" +
                    "    \"deliveryDate\": \"2020-06-06\",\n" +
                    "    \"comment\": \"Saske, come back to Konoha\",\n" +
                    "    \"color\": [\n" +
                    "        \"GREY\"\n" +
                    "    ]\n" +
                    "}";

    String parametersOrderColorGreyAndBlack =
            "{\n" +
                    "    \"firstName\": \"Naruto\",\n" +
                    "    \"lastName\": \"Uchiha\",\n" +
                    "    \"address\": \"Konoha, 142 apt.\",\n" +
                    "    \"metroStation\": 4,\n" +
                    "    \"phone\": \"+7 800 355 35 35\",\n" +
                    "    \"rentTime\": 5,\n" +
                    "    \"deliveryDate\": \"2020-06-06\",\n" +
                    "    \"comment\": \"Saske, come back to Konoha\",\n" +
                    "    \"color\": [\n" +
                    "        \"GREY\",\"BLACK\"" +
                    "    ]\n" +
                    "}";

    String parametersOrderWithoutColors =
            "{\n" +
                    "    \"firstName\": \"Naruto\",\n" +
                    "    \"lastName\": \"Uchiha\",\n" +
                    "    \"address\": \"Konoha, 142 apt.\",\n" +
                    "    \"metroStation\": 4,\n" +
                    "    \"phone\": \"+7 800 355 35 35\",\n" +
                    "    \"rentTime\": 5,\n" +
                    "    \"deliveryDate\": \"2020-06-06\",\n" +
                    "    \"comment\": \"Saske, come back to Konoha\",\n" +
                    "    \"color\": [\n"+
                    "    ]\n" +
                    "}";
}
