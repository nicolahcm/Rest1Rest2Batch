package org.example.tasks;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Duration;

public class StartHttpToR1 {

    private final int TIMEOUT = 40;
    private final OkHttpClient httpClient = new OkHttpClient.Builder()
            .callTimeout(Duration.ofSeconds(TIMEOUT))
            .connectTimeout(Duration.ofSeconds(TIMEOUT))
            .readTimeout(Duration.ofSeconds(TIMEOUT))
            .writeTimeout(Duration.ofSeconds(TIMEOUT))
            .build();
    private final String urlBase = "http://localhost:8080/table1-product/";

    public JSONObject sendGet(int id) throws Exception {

        Request request = new Request.Builder()
                .url(urlBase + id)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);


            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            return jsonObject;

        } catch (Exception e) {
            System.out.println("An error occured. Probably the request requires too much time for a response.");
        }
            return null;
    }
}
