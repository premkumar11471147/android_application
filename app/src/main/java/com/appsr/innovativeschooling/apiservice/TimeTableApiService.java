package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.TimeTable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TimeTableApiService {
    @GET("time_table")
    Call<List<TimeTable>> getAllTimeTables();

    @GET("time_table/{id}")
    Call<TimeTable> getTimeTableById(@Path("id") int id);

    @POST("time_table")
    Call<Void> createTimeTable(@Body TimeTable timeTable);

    @PUT("time_table/{id}")
    Call<Void> updateTimeTable(@Path("id") int id, @Body TimeTable timeTable);

    @DELETE("time_table/{id}")
    Call<Void> deleteTimeTable(@Path("id") int id);
}

