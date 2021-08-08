package jsonSchemaValidationTest;

import api.UserController;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pet.entities.User;
import utils.SchemaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserSchemaTest {
    User user;
    List<User> userList = new ArrayList<>();
    UserController controller;

    @BeforeEach
    public void setup(){
        user = new User()
                .id(new Random().nextLong())
                .username("yaushev")
                .firstName("Эдуард")
                .lastName("Яушев")
                .email("mail@mail.ru")
                .password(RandomStringUtils.randomAlphanumeric(10))
                .phone(RandomStringUtils.randomNumeric(12))
                .userStatus(1);
        controller = new UserController();
        userList.add(user);
    }

    @Test
    public void addUsers(){
        Response response = controller.createWithList(userList);
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.getStatusCode());
        controller.deleteUser(user.getUsername());
    }

    @Test
    public void getUser(){
        controller.createWithList(userList);
        Response response = controller.getUserBy(user.getUsername());
        response.then().body(matchesJsonSchemaInClasspath("userJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.getStatusCode());
        controller.deleteUser(user.getUsername());
    }

    @Test
    public void putUser(){
        controller.createWithList(userList);
        user.username("yaushev777");
        Response response = controller.updateUser(user.getUsername(), user);
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.getStatusCode());
        controller.deleteUser(user.getUsername());
    }

    @Test
    public void deleteUser(){
        controller.createWithList(userList);
        Response response = controller.deleteUser(user.getUsername());
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createWithArray(){
        Response response = controller.createWithArray(userList);
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.getStatusCode());
        controller.deleteUser(user.getUsername());
    }

    @Test
    public void createSingleUser(){
        Response response = controller.createUser(user);
        response.then().body(matchesJsonSchemaInClasspath("defaultResponseJsonSchema.json").using(SchemaFactory.runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.getStatusCode());
        controller.deleteUser(user.getUsername());
    }


}
