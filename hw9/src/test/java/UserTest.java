import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        Writer writer = new Writer();
        List<User> users = User.generateUsers(10);
        writer.writeUsersToFile(users);
        writer.writeAddressesToFile(users);
    }
}
