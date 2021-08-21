package controllers;

import api.ApiService;
import entities.Order;
import utils.JSONMapperImpl;
import utils.PropertyReader;

import java.io.IOException;

public class OrderController<T> {

    private final ApiService<T> rest;
    public final PropertyReader properties = new PropertyReader();
    private final JSONMapperImpl<Order> mapper = new JSONMapperImpl<>();

    public OrderController(ApiService<T> restService){
        rest = restService;
    }

    public T placeOrder(Order order) throws IOException {
        String raw = mapper.serialize(order);
        System.out.println(order.getId());
        return rest.post(properties.getValue("store.placeOrder"), raw);
    }

    public T findOrder(Long orderId) throws IOException {
        return rest.get(properties.getValue("store.getOrder") + orderId);
    }

    public T deleteOrder(Long orderId) throws IOException {
        System.out.println(orderId);
        return rest.delete(properties.getValue("store.getOrder") + orderId);
    }
}
