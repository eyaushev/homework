package api;

import java.io.IOException;
import java.util.HashMap;

public interface ApiService<T> {
    public T post(String url, String json) throws IOException;
    public T post(String url, HashMap<String, String> params) throws IOException;
    public T get(String url) throws IOException;
    public T put(String url, String json) throws IOException;
    public T delete(String url) throws IOException;
}
