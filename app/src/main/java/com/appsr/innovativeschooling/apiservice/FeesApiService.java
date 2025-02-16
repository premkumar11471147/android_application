package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.Fees;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FeesApiService {
    @GET("fees")
    Call<List<Fees>> getAllFees();

    @GET("fees/{id}")
    Call<Fees> getFeesById(@Path("id") int id);

    @POST("fees")
    Call<Void> createFees(@Body Fees fees);

    @PUT("fees/{id}")
    Call<Void> updateFees(@Path("id") int id, @Body Fees fees);

    @DELETE("fees/{id}")
    Call<Void> deleteFees(@Path("id") int id);
}

