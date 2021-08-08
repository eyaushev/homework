package api;

import io.restassured.response.Response;
import pet.entities.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserController extends ApiController<User> {
    public Response createWithList(List<User> users){
        String raw = mapper.serializeList(users);
        return given(requestSpecification).body(raw).post(properties.getValue("user.createWithList"));
    }

    public Response getUserBy(String username){
        return given(requestSpecification).get(properties.getValue("user.getByUsername"), username);
    }

    public Response deleteUser(String username){
        return given(requestSpecification).delete(properties.getValue("user.getByUsername"), username);
    }

    public Response updateUser(String username, User body){
        String raw = mapper.serialize(body);
        return given(requestSpecification).body(raw).put(properties.getValue("user.getByUsername"), username);
    }

    public Response createWithArray(List<User> users){
        String raw = mapper.serializeList(users);
        return given(requestSpecification).body(raw).post(properties.getValue("user.createWithArray"));
    }

    public Response createUser(User user){
        String raw = mapper.serialize(user);
        return given(requestSpecification).body(raw).post(properties.getValue("user.createUser"));
    }
}
