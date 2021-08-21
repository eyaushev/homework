package utils;

import java.io.Serializable;
import java.util.List;

public interface Mapper<T extends Serializable> {
    String serialize(T object);
    T deserialize(String string, Class<T> clazz);
    List<T> deserializeList(String string, Class<T[]> clazz);
}
