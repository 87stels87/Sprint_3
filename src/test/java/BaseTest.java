public class BaseTest {
    protected static final String COURIER_CREATE_PATH = "api/v1/courier/";
    protected static final String COURIER_LOGIN_PATH = "/api/v1/courier/login";
    protected static final String ORDER_CREATE_PATH = "/api/v1/orders";

    Courier courierRandomLoginPasswordFirstName = Courier.getRandomLoginPasswordFirstName();
    Courier courierRandomPasswordFirstName = Courier.getRandomPasswordFirstName();
    Courier courierRandomLoginFirstName = Courier.getRandomLoginFirstName();
    Courier courierRandomFirstName = Courier.getRandomFirstName();
    Courier courierRandomLoginPassword = Courier.getRandomLoginPassword();


    Order orderWithColorBlack = new Order("Иванов", "Андрей", "Москва",
            "Сокольники", "9001231234",
            5, "2020-06-06", "коммент", new String[]{"BLACK"});
    Order orderWithColorGray = new Order("Иванов", "Андрей", "Москва",
            "Сокольники", "9001231234",
            5, "2020-06-06", "коммент", new String[]{"GRAY"});
    Order orderWithColorBlackAndGray = new Order("Иванов", "Андрей", "Москва",
            "Сокольники", "9001231234",
            5, "2020-06-06", "коммент", new String[]{"GRAY","BLACK"});
    Order orderWithoutColor = new Order("Иванов", "Андрей", "Москва",
            "Сокольники", "9001231234",
            5, "2020-06-06", "коммент",null);
}
