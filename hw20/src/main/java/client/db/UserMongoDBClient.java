package client.db;

import DAO.UserMongoDAO;
import DBO.users.UserMongo;
import com.mongodb.client.MongoClient;

import java.util.List;

public class UserMongoDBClient {
    private final UserMongoDAO userMongoDAO = new UserMongoDAO();

    public List<UserMongo> getAllUsers(){
        return userMongoDAO.findAll();
    }

    public void createUser(UserMongo userMongo){
        userMongoDAO.create(userMongo);
    }

    public void createFromList(List<UserMongo> list){
        userMongoDAO.create(list);
    }

    public void deleteAllUsers(){
        userMongoDAO.delete();
    }

    public void closeConnection() {
        MongoClient client = userMongoDAO.getClient();
        if(client!=null) client.close();
    }
}
