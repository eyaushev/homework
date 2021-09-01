package db;

import DBO.users.User;
import client.db.UserDBClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserDBTests {

    private static final UserDBClient dbClient = new UserDBClient();

    private static final List<User> userList = Arrays.asList(
            new User("Эдуард", LocalDate.now(), "Уфа", "79375200491"),
            new User("Александр", LocalDate.now(), "Казань", "79375200492"),
            new User("Ринат", LocalDate.now(), "Москва", "79375200493"),
            new User("Евгений", LocalDate.now(), "Санкт-Петербург", "79375200494")
    );

    @BeforeAll
    public static void createUsers(){
        for (User user : userList) {
            dbClient.createNewUser(user);
        }
    }

    @Test
    void getUsersTest(){
        List<User> users = dbClient.findAllUsers();
        Assertions.assertEquals(users, userList);
    }

    @Test
    void getUserByIdTest(){
        User user = new User("Дмитрий", LocalDate.now(), "Новосибирск", "79375200495");
        dbClient.createNewUser(user);
        User dbUser = dbClient.findUserById(user.getId());
        Assertions.assertEquals(dbUser, user);
    }

    @Test
    void updateUserTest(){
        List<User> users = dbClient.findAllUsers();
        User userBeforeUpdate = users.get(users.size()-1);
        User newUser = new User(userBeforeUpdate.getId(),"Дмитрий", LocalDate.now(), "Новосибирск", "78432361236");
        dbClient.updateUser(newUser);
        User userAfterUpdate = dbClient.findUserById(userBeforeUpdate.getId());
        Assertions.assertEquals(newUser, userAfterUpdate);
    }

    @Test
    void deleteUserTest(){
        List<User> users = dbClient.findAllUsers();
        User lastUser = users.get(users.size()-1);
        dbClient.deleteUser(lastUser);
        Assertions.assertNull(dbClient.findUserById(lastUser.getId()));
    }

    @AfterAll
    public static void deleteUsers(){
        dbClient.deleteAllUsers();
    }
}
