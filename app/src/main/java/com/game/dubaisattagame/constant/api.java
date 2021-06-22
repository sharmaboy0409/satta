package com.game.dubaisattagame.constant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class api {
    public static final String Base_Url="http://onlinelivenews.in/delhiking/";

    public static Retrofit retrofit=null;

    public static String getImagePath()
    {
        return Base_Url;
    }

    public static Retrofit GetApiClient()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
