package utils;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.Serializable;
import java.lang.reflect.Type;

public class JSONMapperImpl<T extends Serializable> implements Mapper<T>{
    Moshi moshi = new Moshi.Builder().build();
    private final T object;

    public String serialize(){
        JsonAdapter<T> jsonAdapter = moshi.adapter((Type) object.getClass());
        return jsonAdapter.toJson(object);
    }

    public T deserialize(String string) throws Exception {
        try {
            JsonAdapter<T> jsonAdapter = moshi.adapter((Type) object.getClass());
            return jsonAdapter.fromJson(string);
        } catch (Exception e){
            throw new Exception();
        }
    }

    public JSONMapperImpl(T object){
        this.object = object;
    }
}
