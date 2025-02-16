package com.appsr.innovativeschooling.retrofit;

import com.appsr.innovativeschooling.apiservice.StudentApiService;
import com.appsr.innovativeschooling.apiservice.StudentPersonalApiService;
import com.appsr.innovativeschooling.apiservice.TeacherProfileApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Retrofit retrofit = null;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://192.168.1.4/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }


    public  <T> T createApiService(Class<T> serviceClass) {
        return getInstance().createApiService(serviceClass);
    }
}

