package com.example.bodyboost.models.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String base_url = "http://10.0.2.2:8000/api/";
    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(base_url).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

}


