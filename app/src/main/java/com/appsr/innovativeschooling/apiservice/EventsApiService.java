package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.Events;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EventsApiService {
    @GET("events")
    Call<List<Events>> getAllEvents();

    @GET("events/{id}")
    Call<Events> getEventById(@Path("id") int id);

    @POST("events")
    Call<Void> createEvent(@Body Events event);

    @PUT("events/{id}")
    Call<Void> updateEvent(@Path("id") int id, @Body Events event);

    @DELETE("events/{id}")
    Call<Void> deleteEvent(@Path("id") int id);
}
