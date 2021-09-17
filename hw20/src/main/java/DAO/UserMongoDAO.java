package DAO;

import DBO.users.UserMongo;
import utils.PropertyLoader;

import java.io.Serializable;

import static utils.MongoDBConnectionFactory.createMongoClient;

public class UserMongoDAO extends AbstractMongoDAO<UserMongo> {
    public UserMongoDAO() {
        setClazz(UserMongo.class);
        setClient(createMongoClient(PropertyLoader.getProperty("mongoURL")));
        setDbName(PropertyLoader.getProperty("mongoDB"));
        setCollectionName(PropertyLoader.getProperty("collection"));
        setMapper();
    }
}
