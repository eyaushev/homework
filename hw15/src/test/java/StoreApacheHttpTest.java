import api.ApacheHttpServiceImpl;
import controllers.OrderController;
import entities.Order;
import io.qameta.allure.Feature;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

@Feature("Тест Store через ApacheHttp")
public class StoreApacheHttpTest {
    Order newOrder;
    OrderController<HttpResponse> controller = new OrderController<>(new ApacheHttpServiceImpl<>());

    @BeforeEach
    public void setup(){
        newOrder = new Order()
                .id(34792834L)
                .petId(34859345L)
                .quantity(new Random().nextInt(10))
                .shipDate("2021-08-03T16:58:09.612+0000")
                .status(Order.StatusEnum.PLACED)
                .complete(true);
    }

    @Test
    @DisplayName("Оставить заказ на питомца")
    public void placeOrder() throws IOException {
        HttpResponse response = controller.placeOrder(newOrder);
        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    @DisplayName("Удалить заказ на питомца")
    public void deleteOrder() throws IOException {
        controller.placeOrder(newOrder);
        HttpResponse response = controller.deleteOrder(newOrder.getId());
        Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    @DisplayName("Отобразить заказ на питомца")
    public void getOrder() throws IOException {
            controller.placeOrder(newOrder);
            HttpResponse response = controller.findOrder(newOrder.getId());
            Assertions.assertEquals(200, response.getStatusLine().getStatusCode());
    }
}
