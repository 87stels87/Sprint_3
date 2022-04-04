import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;

public class BaseTest {
    String courierLogin = RandomStringUtils.randomAlphabetic(10);
    String courierPassword = RandomStringUtils.randomAlphabetic(10);
    String courierFirstName = RandomStringUtils.randomAlphabetic(10);

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
}
