public class BaseTest {
    protected static final String COURIER_CREATE_PATH = "api/v1/courier/";
    protected static final String COURIER_LOGIN_PATH = "/api/v1/courier/login";
    protected static final String ORDER_CREATE_PATH = "/api/v1/orders";

    protected static final String REGISTER_REQUEST_BODY =
            "{\"login\":\"" + Courier.getRandom().login + "\","
                    + "\"password\":\"" + Courier.getRandom().password + "\","
                    + "\"firstName\":\"" + Courier.getRandom().firstName + "\"}";
    protected static final String REGISTER_REQUEST_BODY_WITHOUT_FIRST_NAME =
            "{\"login\":\"" + Courier.getRandom().login + "\","
                    + "\"password\":\"" + Courier.getRandom().password + "\"}";

    protected static final String REGISTER_REQUEST_BODY_WITHOUT_PASSWORD_AND_LOGIN =
            "{\"firstName\":\"" + Courier.getRandom().firstName + "\"}";

    protected static final String REGISTER_REQUEST_BODY_WITHOUT_PASSWORD =
            "{\"login\":\"" + Courier.getRandom().login + "\","
                    + "\"firstName\":\"" + Courier.getRandom().firstName + "\"}";
    protected static final String REGISTER_REQUEST_BODY_WITHOUT_LOGIN =
            "{\"password\":\"" + Courier.getRandom().password + "\","
                    + "\"firstName\":\"" + Courier.getRandom().firstName + "\"}";


    protected static final String LOGIN_REQUEST_BODY_WITHOUT_LOGIN =
            "{\"login\":\"\",\"password\":\"" + Courier.getRandom().password + "\"}";

    protected static final String LOGIN_REQUEST_BODY_WITHOUT_PASSWORD =
            "{\"login\":\"" + Courier.getRandom().login + "\"," + "\"password\":\"\"}";

    protected static final String PARAMETERS_ORDER_COLOR_BLACK =
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


    protected static final String PARAMETERS_ORDER_COLOR_GREY =
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

    protected static final String PARAMETERS_ORDER_COLOR_GREY_AND_BLACK =
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

    protected static final String PARAMETERS_ORDER_WITHOUT_COLORS =
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
                    "    ]\n" +
                    "}";
}
