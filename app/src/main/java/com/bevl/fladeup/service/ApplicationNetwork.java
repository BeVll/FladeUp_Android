package com.bevl.fladeup.service;

import com.bevl.fladeup.constants.Urls;
import com.bevl.fladeup.network.UserApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationNetwork {
    private static ApplicationNetwork instance;
    private Retrofit retrofit;
    public ApplicationNetwork() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApplicationNetwork getInstance() {
        if(instance == null) {
            instance = new ApplicationNetwork();
        }
        return instance;
    }
    public UserApi getUsersApi() { return retrofit.create(UserApi.class); }
}