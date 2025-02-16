package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.HomeWork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface HomeWorkApiService {
    @GET("homework")
    Call<List<HomeWork>> getAllHomeWork();

    @GET("homework/{id}")
    Call<HomeWork> getHomeWorkById(@Path("id") int id);

    @POST("homework")
    Call<Void> createHomeWork(@Body HomeWork homeWork);

    @PUT("homework/{id}")
    Call<Void> updateHomeWork(@Path("id") int id, @Body HomeWork homeWork);

    @DELETE("homework/{id}")
    Call<Void> deleteHomeWork(@Path("id") int id);
}
