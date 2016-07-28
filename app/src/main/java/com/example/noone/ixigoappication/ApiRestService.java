package com.example.noone.ixigoappication;

import com.example.noone.ixigoappication.dataModels.ApiOutput;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by NoOne on 7/27/2016.
 */
public interface ApiRestService {
    @GET("sampleflightdata.json")
    Call<ApiOutput> getDataFromServer();
}
