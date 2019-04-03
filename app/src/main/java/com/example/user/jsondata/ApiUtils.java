package com.example.user.jsondata;

public class ApiUtils {

    public static final String baseUrl =  "https://api.stackexchange.com/2.2/";

    public static Api getApi(){
        return RetrofitClient.getClient(baseUrl).create(Api.class);
    }
}
