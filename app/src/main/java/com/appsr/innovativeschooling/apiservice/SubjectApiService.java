package com.appsr.innovativeschooling.apiservice;

import com.appsr.innovativeschooling.models.Subject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SubjectApiService {
    @GET("subjects")
    Call<List<Subject>> getAllSubjects();

    @GET("subjects/{id}")
    Call<Subject> getSubjectById(@Path("id") int id);

    @POST("subjects")
    Call<Void> createSubject(@Body Subject subject);

    @PUT("subjects/{id}")
    Call<Void> updateSubject(@Path("id") int id, @Body Subject subject);

    @DELETE("subjects/{id}")
    Call<Void> deleteSubject(@Path("id") int id);
}
