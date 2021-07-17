package utils;

import java.io.Serializable;

public interface Mapper<T extends Serializable> {
    String serialize() throws Exception;
    T deserialize(String string) throws Exception;
}
