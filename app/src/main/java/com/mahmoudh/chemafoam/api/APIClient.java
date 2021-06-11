package com.mahmoudh.chemafoam.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {
    static public String baseURL = "http://192.168.43.212:5000/";
    static public Retrofit retrofit=null;

    static public Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
