package com.appsr.innovativeschooling.retrofit;

import com.appsr.innovativeschooling.apiservice.StudentApiService;
import com.appsr.innovativeschooling.apiservice.StudentPersonalApiService;
import com.appsr.innovativeschooling.apiservice.TeacherProfileApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
   // private static RetrofitClient instance = null;
    private static Retrofit retrofit = null;

    private RetrofitClient() {

    }

    public static synchronized Retrofit getInstance() {
        if (retrofit == null) {

            // Create a logging interceptor
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY); // Logs full request & response

            // Attach the interceptor to OkHttpClient
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging) // Add logging
                    .build();
            retrofit =  new Retrofit.Builder()
                    .baseUrl("http://192.168.1.4:8080/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

}

