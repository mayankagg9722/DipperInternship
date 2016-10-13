package com.example.mayank.dipperinternship.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 24/7/16.
 */

public interface ApiCalls {

    @GET("/api/jsonBlob/57f78f7ce4b0bcac9f7baf69")
    Call<JsonObject> dbCallback();
}
