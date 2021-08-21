package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import utils.PropertyReader;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class ApacheHttpServiceImpl<T extends Serializable> implements ApiService<HttpResponse> {
    final String baseURL;
    HttpClient client = HttpClients.createDefault();
    public final PropertyReader properties = new PropertyReader();

    public ApacheHttpServiceImpl(){
        baseURL = properties.getValue("baseURL");
    }

    @Override
    public HttpResponse post(String url, String json) throws IOException {
        HttpPost post = new HttpPost(baseURL + url);
        post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        System.out.println(post.getEntity());
        return client.execute(post);
    }

    @Override
    public HttpResponse post(String url, HashMap<String, String> params) throws IOException {
        return null;
    }

    @Override
    public HttpResponse get(String url) throws IOException {
        HttpGet get = new HttpGet(baseURL + url);
        System.out.println(get.getURI());
        return client.execute(get);
    }

    @Override
    public HttpResponse put(String url, String json) throws IOException {
        HttpPut put = new HttpPut(baseURL + url);
        put.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        return client.execute(put);
    }

    @Override
    public HttpResponse delete(String url) throws IOException {
        HttpDelete delete = new HttpDelete(baseURL + url);
        return client.execute(delete);
    }
}
