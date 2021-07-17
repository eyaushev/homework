import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JSONMapperImpl;
import utils.Mapper;
import utils.XMLMapperImpl;
import java.util.Arrays;
import java.util.List;


public class UserTest {

    User user = new User();
    List<User> userList = Arrays.asList(
            new User(),
            new User(),
            new User(),
            new User()
    );
    Users users = new Users(userList);

    @Test
    void userXML() throws Exception {
        Mapper<User> mapper = new XMLMapperImpl<>(user);
        String userString = mapper.serialize();
        User deserialized = mapper.deserialize(userString);
        System.out.println(userString);
        Assertions.assertEquals(user.toString(), deserialized.toString());
    }

    @Test
    void userJSON() throws Exception {
        Mapper<User> mapper = new JSONMapperImpl<>(user);
        String jsonString = mapper.serialize();
        User deserialized = mapper.deserialize(jsonString);
        Assertions.assertEquals(user.toString(), deserialized.toString());
    }

    @Test
    void userListXML() throws Exception {
        Mapper<Users> mapper = new XMLMapperImpl<>(users);
        String userListString = mapper.serialize();
        Users deserialized = mapper.deserialize(userListString);
        System.out.println(userListString);
        Assertions.assertEquals(4, deserialized.getUsers().size());
    }

    @Test
    void userListJSON() throws Exception {
        Mapper<Users> mapper = new JSONMapperImpl<>(users);
        String jsonString = mapper.serialize();
        Users deserialized = mapper.deserialize(jsonString);
        System.out.println(jsonString);
        Assertions.assertEquals(4, deserialized.getUsers().size());
    }
}
