import api.ApiClient;
import petstore.utils.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import api.StoreApi;
import petstore.model.ModelApiResponse;
import petstore.model.Order;

import java.util.Random;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static petstore.utils.GsonObjectMapper.gson;

/**
 * API tests for StoreApi
 */

public class StoreApiTest {

    private StoreApi api;
    private Order newOrder;

    @Before
    public void createApi() {
        newOrder = new Order()
                .id(new Random().nextInt(1000))
                .petId(new Random().nextInt(1000))
                .quantity(new Random().nextInt(10))
                .shipDate("2021-08-03T16:58:09.612+0000")
                .status(Order.StatusEnum.PLACED)
                .complete(true);

        api = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder().setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(new PropertyReader().getValue("baseURL")))).store();
    }

    /**
     * Order not found
     */
    @Test
    public void shouldSee404AfterDeleteOrder() {
        api.placeOrder().body(newOrder).execute(ResponseBody::prettyPeek);
        api.deleteOrder()
                .orderIdPath(newOrder.getId()).execute(ResponseBody::prettyPeek);
        ModelApiResponse deleteResponse = api.deleteOrder()
                .orderIdPath(newOrder.getId()).execute(ResponseBody::prettyPeek).as(ModelApiResponse.class);
        Assertions.assertEquals(404, deleteResponse.getCode());
    }


    /**
     * successful operation
     */
    @Test
    public void shouldSee200AfterGetInventory() {
        Response inventoryResponse =  api.getInventory().execute(ResponseBody::prettyPeek);
        Assertions.assertEquals(200, inventoryResponse.getStatusCode());
    }


    /**
     * successful operation
     */
    @Test
    public void getOrderById() {
        api.placeOrder().body(newOrder).execute(ResponseBody::prettyPeek);
        Order order = api.getOrderById()
                .orderIdPath(newOrder.getId()).executeAs(ResponseBody::prettyPeek);
        Assertions.assertEquals(newOrder, order);
        api.deleteOrder().orderIdPath(newOrder.getId()).execute(ResponseBody::prettyPeek);
    }


    /**
     * Order not found
     */
    @Test
    public void shouldSee404AfterGetOrderById() {
        api.placeOrder().body(newOrder).execute(ResponseBody::prettyPeek);
        api.deleteOrder().orderIdPath(newOrder.getId()).execute(ResponseBody::prettyPeek);
        Response response = api.getOrderById()
                .orderIdPath(newOrder.getId()).execute(ResponseBody::prettyPeek);
        Assertions.assertEquals(404, response.getStatusCode());
    }


    /**
     * successful operation
     */
    @Test
    public void placeOrder() {
        Order placedOrder = api.placeOrder()
                .body(newOrder).executeAs(ResponseBody::prettyPeek);

        Assertions.assertEquals(newOrder, placedOrder);
    }
}