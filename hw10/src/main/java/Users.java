import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root
public class Users implements Serializable {
    @ElementList(inline=true)
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public Users(List<User> users){
        this.users = users;
    }

    public Users(){ }
}
