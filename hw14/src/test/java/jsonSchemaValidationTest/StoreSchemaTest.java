package jsonSchemaValidationTest;

import api.OrderController;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pet.entities.Order;
import utils.SchemaFactory;

import java.util.Random;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class StoreSchemaTest {
    Order newOrder;
    OrderController controller;

    @BeforeEach
    public void setup(){
        newOrder = new Order()
                .id(new Random().nextLong())
                .petId(new Random().nextLong())
                .quantity(new Random().nextInt(10))
                .shipDate("2021-08-03T16:58:09.612+0000")
                .status(Order.StatusEnum.PLACED)
                .complete(true);
        controller = new OrderController();
    }

    @Test
    public void placeOrder(){
        Response response = controller.placeOrder(newOrder);
        response.then().body(matchesJsonSchemaInClasspath("orderJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.statusCode());
        controller.deleteOrder(newOrder);
    }

    @Test
    public void deleteOrder(){
        controller.placeOrder(newOrder);
        Response response = controller.deleteOrder(newOrder);
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void getOrder(){
        controller.placeOrder(newOrder);
        Response response = controller.findOrder(newOrder.getId());
        response.then().body(matchesJsonSchemaInClasspath("orderJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.statusCode());
        controller.deleteOrder(newOrder);
    }
}
