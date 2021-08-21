import api.OkHttpServiceImpl;
import controllers.OrderController;
import entities.Order;
import io.qameta.allure.Feature;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;


@Feature("Тест Store через OkHttp")
public class StoreOkHttpTest {
    Order newOrder;
    OrderController<Response> controller = new OrderController<>(new OkHttpServiceImpl<>());

    @BeforeEach
    public void setup(){
        newOrder = new Order()
                .id(34792834L)
                .petId(new Random().nextLong())
                .quantity(new Random().nextInt(10))
                .shipDate("2021-08-03T16:58:09.612+0000")
                .status(Order.StatusEnum.PLACED)
                .complete(true);
    }

    @Test
    @DisplayName("Оставить заказ на питомца")
    public void placeOrder(){
        try {
            Response response = controller.placeOrder(newOrder);
            Assertions.assertEquals(200, response.code());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Удалить заказ на питомца")
    public void deleteOrder(){
        try {
            controller.placeOrder(newOrder);
            Response response = controller.deleteOrder(newOrder.getId());
            Assertions.assertEquals(200, response.code());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Отобразить заказ на питомца")
    public void getOrder(){
        try {
            controller.placeOrder(newOrder);
            Response response = controller.findOrder(newOrder.getId());
            Assertions.assertEquals(200, response.code());
            controller.deleteOrder(newOrder.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
