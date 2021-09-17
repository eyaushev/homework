package DAO;

import DBO.users.User;

import java.io.Serializable;

public class UserDAO extends AbstractDAO<User> implements Serializable {
    public UserDAO(){
        setClazz(User.class);
    }
}
