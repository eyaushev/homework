package DAO;

import DBO.users.User;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO(){
        setClazz(User.class);
    }
}
