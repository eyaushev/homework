package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class JSONMapperImpl<T extends Serializable> implements Mapper<T>{
    GsonBuilder builder;
    Gson gson;

    public String serialize(T object){
        return gson.toJson(object);
    }

    public String serializeList(List<T> object){
        return gson.toJson(object);
    }

    public T deserialize(String string, Class<T> clazz) {
        return (T) gson.fromJson(string, clazz);
    }

    public List<T> deserializeList(String string, Class<T[]> clazz) {
        T[] arr = gson.fromJson(string, clazz);
        return Arrays.asList(arr);
    }

    public JSONMapperImpl() {
        this.builder = new GsonBuilder();
        this.gson = builder.create();
    }
}
