package com.example.user.jsondata;

import com.example.user.jsondata.Model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Response> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Response> getAnswers(@Query("tagged") String tags);
}
