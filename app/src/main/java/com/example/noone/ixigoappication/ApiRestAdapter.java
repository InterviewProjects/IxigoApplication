package com.example.noone.ixigoappication;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NoOne on 7/27/2016.
 */
public class ApiRestAdapter {
    private static final String MAGIC_REST_ENDPOINT = "http://blog.ixigo.com/";
    private static ApiRestService restService;

    static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

    public static ApiRestService getRestService() {
        OkHttpClient client = okHttpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MAGIC_REST_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        restService = retrofit.create(ApiRestService.class);

        return restService;
    }


}
