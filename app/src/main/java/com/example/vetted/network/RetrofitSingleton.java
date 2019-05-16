package com.example.vetted.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static final String BASE_URL = "https://api.yelp.com/v3/";

    private static Retrofit instance;

    private RetrofitSingleton() {
    }


    public static Retrofit getInstance() {


        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
