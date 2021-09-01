package client.db;

import DAO.UserDAO;
import DBO.users.User;

import java.util.List;

public class UserDBClient {
    private final UserDAO userDAO = new UserDAO();

    public void createNewUser(User user){
        userDAO.save(user);
    }

    public User findUserById(int id){
        return userDAO.findById(id);
    }

    public List<User> findAllUsers(){
        return userDAO.findAll();
    }

    public void updateUser(User user){
        userDAO.update(user);
    }

    public void deleteUser(User user){
        userDAO.delete(user);
    }

    public void deleteAllUsers(){
        userDAO.deleteAll();
    }
}
