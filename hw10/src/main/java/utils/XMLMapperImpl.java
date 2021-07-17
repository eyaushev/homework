package utils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.File;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class XMLMapperImpl<T extends Serializable> implements Mapper<T> {
    private final Serializer serializer = new Persister();
    private final File file = new File("outputs/output.xml");
    private final T object;

    public String serialize() throws Exception{
        try{
            serializer.write(object, file);
            return Files.readString(file.toPath(), StandardCharsets.UTF_8);

        } catch (Exception e){
            throw new Exception();
        }
    }

    public T deserialize(String string) throws Exception {
        Serializer serializer = new Persister();
        try {
            return (T) serializer.read(object.getClass(), string);
        } catch (Exception e){
            throw new Exception();
        }

    }

    public XMLMapperImpl(T object){
        this.object = object;
    }
}
