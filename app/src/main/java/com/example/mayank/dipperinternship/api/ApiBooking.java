package com.example.mayank.dipperinternship.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mayank on 12-10-2016.
 */
public interface ApiBooking {
    @GET("/api/jsonBlob/57f78e9ae4b0bcac9f7baec4")
    Call<JsonObject> dbCallback();
}
