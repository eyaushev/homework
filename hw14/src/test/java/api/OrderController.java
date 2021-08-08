package api;

import io.restassured.response.Response;
import pet.entities.Order;

import static io.restassured.RestAssured.given;

public class OrderController extends ApiController<Order> {
    public Response placeOrder(Order order){
        String raw = mapper.serialize(order);
        return given(requestSpecification).body(raw).post(properties.getValue("store.placeOrder"));
    }

    public Response findOrder(Long orderId){
        return given(requestSpecification).get(properties.getValue("store.getOrder"), orderId);
    }

    public Response deleteOrder(Order order){
        return given(requestSpecification).delete(properties.getValue("store.getOrder"), order.getId());
    }
}
