package api;

import okhttp3.*;
import utils.PropertyReader;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OkHttpServiceImpl<T extends Serializable> implements ApiService<Response> {
    final String baseURL;
    final OkHttpClient client;
    public final PropertyReader properties = new PropertyReader();
    private final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final MediaType FORM = MediaType.parse("multipart/form-data");

    public OkHttpServiceImpl(){
        baseURL = properties.getValue("baseURL");
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
//        clientBuilder.addInterceptor(new AllureOkHttp3());
        client = clientBuilder.build();
    }

    public Response post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(baseURL + url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println("ADD: " + response.code());
            return response;
        }
    }

    @Override
    public Response post(String url, HashMap<String, String> params) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(baseURL + url)
                .post(formBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response;
        }
    }

    public Response get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(baseURL + url)
                .get()
                .build();
        System.out.println(request.url().toString());
        try (Response response = client.newCall(request).execute()) {
            return response;
        }
    }

    public Response put(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(baseURL + url)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response;
        }
    }

    public Response delete(String url) throws IOException {
        Request request = new Request.Builder()
                .url(baseURL + url)
                .delete()
                .build();
        System.out.println(request.url());
        try (Response response = client.newCall(request).execute()) {
            System.out.println("DELETE: " + response.code());
            return response;
        }
    }
}
