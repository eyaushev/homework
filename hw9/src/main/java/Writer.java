import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    private final File usersFile = new File("hw9/outputs/users.txt");
    private final File addressesFile = new File("hw9/outputs/addresses.txt");

    public void writeUsersToFile(List<User> users){
        try {
            FileWriter fw = new FileWriter(usersFile);
            users.forEach(user -> {
                try {
                    fw.write(user.toString() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeAddressesToFile(List<User> users){
        try {
            FileWriter fw = new FileWriter(addressesFile);
            users.forEach(user -> {
                user.setHomeAddress(new Address());
                try {
                    fw.write(user.getName() + ": " + user.getHomeAddress() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
