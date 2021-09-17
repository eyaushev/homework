package db;

import DBO.users.User;
import DBO.users.UserMongo;
import client.db.UserDBClient;
import client.db.UserMongoDBClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserMongoDBTests {
    private static final UserMongoDBClient dbClient = new UserMongoDBClient();

//    private static final List<UserMongo> userList = Arrays.asList(
//            new UserMongo("Eduard", LocalDate.now(), "Kazan", "79375200493"),
//            new UserMongo("Rinat", LocalDate.now(), "Kazan", "79375200493"),
//            new UserMongo("Alexander", LocalDate.now(), "Kazan", "79375200493"),
//            new UserMongo("Dmitry", LocalDate.now(), "Kazan", "79375200493")
//    );

//    @BeforeAll
//    public static void createUsers(){
//        List<UserMongo> userList = Arrays.asList(
//                new UserMongo("Eduard", LocalDate.now(), "Kazan", "79375200493"),
//                new UserMongo("Rinat", LocalDate.now(), "Kazan", "79375200493"),
//                new UserMongo("Alexander", LocalDate.now(), "Kazan", "79375200493"),
//                new UserMongo("Dmitry", LocalDate.now(), "Kazan", "79375200493")
//        );
//
//        for (UserMongo user : userList) {
//            dbClient.createUser(user);
//        }
//    }

    @AfterAll
    public static void disconnect() {
        dbClient.deleteAllUsers();
        dbClient.closeConnection();
    }

    @Test
    void getUsersTest(){
        List<UserMongo> userList = Arrays.asList(
                new UserMongo(),
                new UserMongo(),
                new UserMongo()
        );

        dbClient.createFromList(userList);

        List<UserMongo> users = dbClient.getAllUsers();

        Assertions.assertArrayEquals(userList.toArray(), users.toArray());
    }

}
